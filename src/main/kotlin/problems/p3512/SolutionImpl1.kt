package problems.p3512

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.50 MB` (Beats `96.30%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/solutions/7381379/kotlin-on-1ms-o1-by-alexeyminkin-y2rl)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(nums: IntArray, k: Int): Int {
        var sum = 0
        for (i in 0 until nums.size) {
            sum += nums[i]
        }
        return sum % k
    }
}