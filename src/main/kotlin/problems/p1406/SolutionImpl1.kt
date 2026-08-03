package problems.p1406

class SolutionImpl1 : Solution {
    override fun stoneGameIII(sv: IntArray): String {
        val n = sv.size
        val dp = IntArray(n + 1)
        dp[n - 1] = sv[n - 1]
        if (n > 1) dp[n - 2] = Math.max(sv[n - 2] - dp[n - 1], sv[n - 2] + sv[n - 1])
        for (i in n - 3 downTo 0)
            dp[i] = maxOf(sv[i] - dp[i + 1], sv[i] + sv[i + 1] - dp[i + 2], sv[i] + sv[i + 1] + sv[i + 2] - dp[i + 3])
        return if (dp[0] > 0) "Alice" else if (dp[0] < 0) "Bob" else "Tie"
    }
}