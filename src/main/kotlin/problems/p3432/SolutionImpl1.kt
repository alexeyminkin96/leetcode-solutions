package problems.p3432

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.14 MB` (Beats `88.24%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun countPartitions(nums: IntArray): Int {
        var result = 0
        var rightSum = 0
        var leftSum = 0
        for (i in 0 until nums.size) {
            rightSum += nums[i]
        }
        for (i in 0 until nums.size - 1) {
            leftSum += nums[i]
            rightSum -= nums[i]
            if ((leftSum - rightSum) % 2 == 0)
                result++
        }
        return result
    }
}