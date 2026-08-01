package problems.p0486

class SolutionImpl1 : Solution {
    override fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        if (n and 1 == 0) return true

        val maxEdge = Math.max(nums[0], nums[n - 1])
        var evens = -maxEdge
        var odds = 0
        for (i in 0 until n)
            if (i and 1 == 0) evens += nums[i] else odds += nums[i]
        if (Math.abs(evens - odds) > maxEdge) return false

        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n)
            dp[i][i] = nums[i]
        for (len in 2..n) {
            for (l in 0..n - len) {
                val r = l + len - 1
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1])
            }
        }
        return dp[0][n - 1] >= 0
    }
}