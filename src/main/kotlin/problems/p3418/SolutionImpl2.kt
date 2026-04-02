package problems.p3418

class SolutionImpl2 : Solution {
    override fun maximumAmount(coins: Array<IntArray>): Int {
        val nul = -1_000_000_000
        val neutrals = 2
        val m = coins.size
        val n = coins[0].size
        val dp = Array(neutrals + 2) { Array(m + 1) { IntArray(n + 1) { nul } } }
        for (k in 1..neutrals + 1) dp[k][0][1] = 0
        for (i in 0 until m)
            for (j in 0 until n)
                for (k in 1..neutrals + 1)
                    dp[k][i + 1][j + 1] = Math.max(
                        Math.max(dp[k - 1][i][j + 1], dp[k - 1][i + 1][j]),
                        Math.max(dp[k][i][j + 1], dp[k][i + 1][j]) + coins[i][j]
                    )
        return dp[neutrals + 1][m][n]
    }
}
