package problems.p3381

/**
 * **LeetCode Performance:**
 * - Runtime: `3301 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `95.63 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * k)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun maxSubarraySum(nums: IntArray, k: Int): Long {
        var maxSum = Long.MIN_VALUE

        for (i in 0 until minOf(k, nums.size - k + 1)) {
            var localMaxSum = Long.MIN_VALUE
            var continuousSum = 0L
            for (j in i until (nums.size - k + 1) step k) {
                var sum = 0L
                for (t in j until j + k) {
                    sum += nums[t]
                }
                continuousSum = Math.max(sum, continuousSum + sum)
                localMaxSum = Math.max(localMaxSum, continuousSum)
            }
            maxSum = Math.max(maxSum, localMaxSum)
        }
        return maxSum
    }
}
