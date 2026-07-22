package problems.p3501

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `141 ms` (Beats `86.89%` of Kotlin submissions)
 * - Memory: `132.29 MB` (Beats `44.26%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + q log n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): IntArray {
        val n = s.length
        val starts = IntArray(n)
        val ends = IntArray(n)
        val left = IntArray(n)
        val right = IntArray(n)
        var count = 0
        var zeros = 0
        var ones = 0
        var i = 0

        while (i < n) {
            if (s[i] == '0') {
                zeros = 0
                while (i < n && s[i] == '0') {
                    zeros++
                    i++
                }
            } else {
                val start = i
                while (i < n && s[i] == '1') {
                    ones++
                    i++
                }
                if (start > 0 && i < n) {
                    var j = i
                    while (j < n && s[j] == '0') j++
                    starts[count] = start
                    ends[count] = i - 1
                    left[count] = zeros
                    right[count] = j - i
                    count++
                }
            }
        }

        var size = 1
        while (size < count) size = size shl 1
        val tree = IntArray(size shl 1)
        for (j in 0 until count) tree[size + j] = left[j] + right[j]
        for (j in size - 1 downTo 1)
            tree[j] = Math.max(tree[j shl 1], tree[j shl 1 or 1])

        return IntArray(queries.size) {
            val l = queries[it][0]
            val r = queries[it][1]

            var first = Arrays.binarySearch(starts, 0, count, l)
            first = if (first < 0) -first - 1 else first + 1

            var last = Arrays.binarySearch(ends, 0, count, r)
            last = if (last < 0) -last - 2 else last - 1

            var max = 0
            if (first <= last) {
                fun value(i: Int) =
                    Math.min(left[i], starts[i] - l) +
                        Math.min(right[i], r - ends[i])

                max = Math.max(value(first), value(last))

                var a = size + first + 1
                var b = size + last
                while (a < b) {
                    if (a and 1 == 1) max = Math.max(max, tree[a++])
                    if (b and 1 == 1) max = Math.max(max, tree[--b])
                    a = a shr 1
                    b = b shr 1
                }
            }
            ones + max
        }
    }
}