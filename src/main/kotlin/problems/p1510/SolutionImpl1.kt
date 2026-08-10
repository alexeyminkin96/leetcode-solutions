package problems.p1510

class SolutionImpl1 : Solution {
    override fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1)
        for (i in n - 1 downTo 0) {
            var x = 1
            while (i + x * x <= n) {
                if (!dp[i + x * x]) {
                    dp[i] = true
                    break
                }
                x++
            }
        }
        return dp[0]
    }
}