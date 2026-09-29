package problems.p2267

/**
 * **LeetCode Performance**
 * - Runtime: `16 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.87 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(m * n * (m + n))`
 * - Space: `O(n * (m + n))`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/solutions/8546461/kotlin-omnmn-16ms-onmn-primitives-only-b-6axm)
 */
class SolutionImpl3 : Solution {
    override fun hasValidPath(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val pathLength = m + n - 1
        if (pathLength and 1 == 1) return false
        val half = pathLength shr 1
        val dp = Array(n + 1) { BooleanArray(half + 3) }
        dp[1][1] = true
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '(')
                    for (k in Math.min(i + j + 2, half + 1) downTo 1)
                        dp[j + 1][k] = dp[j + 1][k - 1] || dp[j][k - 1]
                else
                    for (k in 1..Math.min(i + j + 2, half + 1))
                        dp[j + 1][k] = dp[j + 1][k + 1] || dp[j][k + 1]
            }
        }
        return dp[n][1]
    }
}