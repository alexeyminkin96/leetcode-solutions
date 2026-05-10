package problems.p2770

class SolutionImpl2 : Solution {
    override fun maximumJumps(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = IntArray(n) { -1 }
        dp[0] = 0
        for (i in 0 until n - 1)
            if (dp[i] != -1)
                for (j in i + 1 until n)
                    if (Math.abs(nums[j] - nums[i]) <= target)
                        dp[j] = Math.max(dp[j], dp[i] + 1)
        return dp[n - 1]
    }
}