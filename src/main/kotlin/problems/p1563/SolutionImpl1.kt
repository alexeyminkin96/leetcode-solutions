package problems.p1563

/**
 * **LeetCode Performance:**
 * - Runtime: `223 ms` (Beats `0.00%` of Kotlin submissions)
 * - Memory: `48.08 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^3)`
 * - Space: `O(n^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game-v/solutions/8465903/kotlin-on3-223ms-on2-by-alexeyminkin-os3r)
 */
class SolutionImpl1 : Solution {
    override fun stoneGameV(stoneValue: IntArray): Int {
        val n = stoneValue.size
        val sums = IntArray(n + 1)
        for (i in 0 until n)
            sums[i + 1] = sums[i] + stoneValue[i]
        val dp = Array(n) { IntArray(n) }
        for (len in 1 until n) {
            for (r in len until n) {
                val l = r - len
                var lSum = 0
                var rSum = sums[r + 1] - sums[l]
                for (i in l until r) {
                    lSum += stoneValue[i]
                    rSum -= stoneValue[i]
                    if (lSum <= rSum) dp[l][r] = Math.max(dp[l][r], lSum + dp[l][i])
                    if (lSum >= rSum) dp[l][r] = Math.max(dp[l][r], rSum + dp[i + 1][r])
                }
            }
        }
        return dp[0][n - 1]
    }
}