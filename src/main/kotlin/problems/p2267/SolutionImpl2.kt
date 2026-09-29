package problems.p2267

class SolutionImpl2 : Solution {
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
                    for (k in half + 1 downTo 1)
                        dp[j + 1][k] = dp[j + 1][k - 1] || dp[j][k - 1]
                else
                    for (k in 1..half + 1)
                        dp[j + 1][k] = dp[j + 1][k + 1] || dp[j][k + 1]
            }
        }
        return dp[n][1]
    }
}