package problems.p1621

class SolutionImpl1 : Solution {
    override fun numberOfSets(n: Int, k: Int): Int {
        var dp = IntArray((k shl 1) + 2) { 1 }
        dp[0] = 0
        var nextDp = IntArray((k shl 1) + 2)
        for (l in 0 until n - k - 1) {
            for (i in 1 until dp.size)
                nextDp[i] = (nextDp[i - 1] + dp[i]) % 1_000_000_007
            val t = dp
            dp = nextDp
            nextDp = t
        }
        return dp[dp.size - 1]
    }
}