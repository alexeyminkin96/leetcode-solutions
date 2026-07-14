package problems.p3336

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `105 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((log m + n) * m²)` - m - max(nums)
 * - Space: `O(m²)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/solutions/8396560/kotlin-onlogmm2-132ms-om2-by-alexeyminki-qv9d)
 */
class SolutionImpl2 : Solution {
    override fun subsequencePairCount(nums: IntArray): Int {
        val mod = 1_000_000_007
        var size = 0
        for (num in nums) size = Math.max(size, num + 1)
        var dp = Array(size) { IntArray(size) }
        dp[0][0] = 1
        var next = Array(size) { IntArray(size) }
        var max = 0
        fun next(i: Int, j: Int, count: Int) {
            next[i][j] += count
            if (next[i][j] >= mod) next[i][j] -= mod
        }
        val gcds = Array(size) { i -> IntArray(size) { j -> gcd(i, j) } }
        for (num in nums) {
            for (i in 0..max) {
                for (j in 0..max) {
                    val count = dp[i][j]
                    if (count == 0) continue
                    next(i, j, count)
                    next(gcds[i][num], j, count)
                    next(i, gcds[num][j], count)
                }
            }
            val buf = dp
            dp = next
            next = buf
            for (row in next) Arrays.fill(row, 0)
            max = Math.max(max, num)
        }
        var res = 0L
        for (i in 1 until size) res += dp[i][i]
        return (res % mod).toInt()
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}