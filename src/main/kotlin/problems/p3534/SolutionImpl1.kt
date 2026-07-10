package problems.p3534

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `60 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `112.64 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + q) log n)`
 * - Space: `O(n log n)`
 */
class SolutionImpl1 : Solution {
    override fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): IntArray {
        val sort = LongArray(n) { (nums[it].toLong() shl 32) or it.toLong() }
        Arrays.sort(sort)
        val idx = IntArray(n)
        for (i in 0 until n) {
            idx[sort[i].toInt()] = i
            nums[i] = (sort[i] shr 32).toInt()
        }

        val jump = Array(32 - n.countLeadingZeroBits()) { IntArray(n) }
        var l = 0
        var r = 1
        while (r < n) if (nums[r] - nums[l] > maxDiff) jump[0][l++] = r - 1 else jump[0][l] = r++
        while (l < n) jump[0][l++] = r - 1

        for (k in 1 until jump.size)
            for (i in 0 until n)
                jump[k][i] = jump[k - 1][jump[k - 1][i]]

        return IntArray(queries.size) { i ->
            var l = idx[queries[i][0]]
            var r = idx[queries[i][1]]
            if (l > r) {
                val b = l
                l = r
                r = b
            }
            if (l == r) return@IntArray 0
            var count = 1
            for (k in jump.size - 1 downTo 0)
                if (jump[k][l] < r) {
                    l = jump[k][l]
                    count += 1 shl k
                }
            if (jump[0][l] >= r) count else -1
        }
    }
}