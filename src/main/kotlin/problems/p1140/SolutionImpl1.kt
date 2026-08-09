package problems.p1140

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `75.00%` of Kotlin submissions)
 * - Memory: `42.87 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^3)`
 * - Space: `O(n^2)`
 */
class SolutionImpl1 : Solution {
    override fun stoneGameII(piles: IntArray): Int {
        val n = piles.size
        val ps = IntArray(n + 1)
        for (i in n - 1 downTo 0) ps[i] = ps[i + 1] + piles[i]
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (i in n - 1 downTo 0) {
            val cur = dp[i]
            for (m in 1..n) {
                cur[m] = ps[i]
                if (i + (m shl 1) >= n) continue
                var min = Int.MAX_VALUE
                for (x in 1..(m shl 1)) min = Math.min(min, dp[i + x][Math.max(m, x)])
                cur[m] -= min
            }
        }
        return dp[0][1]
    }
}