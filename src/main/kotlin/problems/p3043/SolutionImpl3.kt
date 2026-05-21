package problems.p3043

/**
 * **LeetCode Performance:**
 * - Runtime: `34 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `80.49 MB` (Beats `9.09%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(min(n, m))`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/solutions/8283396/kotlin-onmlogm-34ms-onlogm-primitives-on-5jd1)
 */
class SolutionImpl3 : Solution {
    override fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val min = if (arr1.size < arr2.size) arr1 else arr2
        val max = if (arr1.size < arr2.size) arr2 else arr1
        val tree = IntArray(min.size * 100)
        val buf = IntArray(9)
        var globNext = 0
        fun numToBuf(num: Int): Int {
            var num = num
            var j = -1
            while (num > 0) {
                buf[++j] = num % 10
                num /= 10
            }
            return j
        }
        for (i in 0 until min.size) {
            var prev = 0
            for (j in numToBuf(min[i]) downTo 0) {
                val next = 10 * prev + buf[j]
                if (tree[next] == 0) tree[next] = ++globNext
                prev = tree[next]
            }
        }
        var res = 0
        for (i in 0 until max.size) {
            val length = numToBuf(max[i])
            var j = length
            var prev = 0
            while (j >= 0 && tree[10 * prev + buf[j]] != 0)
                prev = tree[10 * prev + buf[j--]]
            res = Math.max(res, length - j)
        }
        return res
    }
}
