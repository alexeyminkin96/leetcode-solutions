package problems.p2770

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.83 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/solutions/8182269/kotlin-on2-21ms-on-by-alexeyminkin-670i)
 */
class SolutionImpl1 : Solution {
    override fun maximumJumps(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = IntArray(n) { -1 }
        dp[0] = 0
        for (j in 1 until n)
            for (i in 0 until j)
                if (dp[i] != -1 && Math.abs(nums[j] - nums[i]) <= target)
                    dp[j] = Math.max(dp[j], dp[i] + 1)
        return dp[n - 1]
    }
}