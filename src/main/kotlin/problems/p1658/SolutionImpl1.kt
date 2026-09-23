package problems.p1658

/**
 * **LeetCode Performance**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.26 MB` (Beats `87.50%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/solutions/8535783/kotlin-on-5ms-o1-by-alexeyminkin-000s)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(nums: IntArray, x: Int): Int {
        var targetSum = -x
        for (num in nums) targetSum += num
        if (targetSum < 0) return -1
        var windowSum = 0
        var maxLen = -1
        var l = 0
        for (r in 0 until nums.size) {
            windowSum += nums[r]
            while (windowSum > targetSum) windowSum -= nums[l++]
            if (windowSum == targetSum) maxLen = Math.max(maxLen, r - l + 1)
        }
        return if (maxLen == -1) -1 else nums.size - maxLen
    }
}