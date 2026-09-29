package problems.p2267

class SolutionImpl1 : Solution {
    override fun hasValidPath(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(n + 1) { BooleanArray(m + n + 2) }
        dp[1][1] = true
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '(')
                    for (k in m + n downTo 1)
                        dp[j + 1][k] = dp[j + 1][k - 1] || dp[j][k - 1]
                else
                    for (k in 1..m + n)
                        dp[j + 1][k] = dp[j + 1][k + 1] || dp[j][k + 1]
            }
        }
        return dp[n][1]
    }
}