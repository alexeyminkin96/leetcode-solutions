package problems.p3381

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `82.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/solutions/7377320/kotlin-on-8ms-ok-by-alexeyminkin-k0zt)
 */
class SolutionImpl2 : Solution {
    override fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val continuousSums = LongArray(k)
        var maxSum = Long.MIN_VALUE
        var windowSum = 0L

        for (i in 0 until nums.size) {
            windowSum += nums[i]
            if (i < k - 1) continue
            val rem = i % k
            continuousSums[rem] = Math.max(windowSum, continuousSums[rem] + windowSum)
            maxSum = Math.max(maxSum, continuousSums[rem])
            windowSum -= nums[i - (k - 1)]
        }

        return maxSum
    }
}
