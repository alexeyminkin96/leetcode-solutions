package problems.p0486

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.22 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        if (n and 1 == 0) return true

        val maxEdge = Math.max(nums[0], nums[n - 1])
        var evens = -maxEdge
        var odds = 0
        for (i in 0 until n)
            if (i and 1 == 0) evens += nums[i] else odds += nums[i]
        if (Math.abs(evens - odds) > maxEdge) return false

        val dp = Arrays.copyOf(nums, n)
        for (r in 1 until n)
            for (l in r - 1 downTo 0)
                dp[l] = Math.max(nums[l] - dp[l + 1], nums[r] - dp[l])
        return dp[0] >= 0
    }
}