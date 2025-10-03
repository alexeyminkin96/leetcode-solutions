package problems.p0016

/**
 * **[3Sum Closest](https://leetcode.com/problems/3sum-closest/)**
 *
 * **Description:**
 * - Find three integers in nums whose sum is closest to target.
 *
 * **Constraints:**
 * - 3 <= nums.length <= 500
 * - -1000 <= nums[i] <= 1000
 * - -10^4 <= target <= 10^4
 *
 * **Example:**
 * - Input: nums = [-1,2,1,-4], target = 1
 * - Output: 2
 */
interface Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int
}
