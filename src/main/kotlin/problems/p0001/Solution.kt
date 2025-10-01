package problems.p0001

/**
 * **[Two Sum](https://leetcode.com/problems/two-sum/)**
 *
 * **Description:**
 * - Given an array of integers `nums` and an integer `target`,
 *   return indices of the two numbers such that they add up to `target`.
 *
 * **Constraints:**
 * - `2 <= nums.length <= 10^4`
 * - `-10^9 <= nums[i], target <= 10^9`
 * - Exactly one valid answer exists
 *
 * **Notes:**
 * - You cannot use the same element twice
 *
 * **Examples:**
 * - Input: nums = [2,7,11,15], target = 9
 * - Output: [0,1]
 * - Explanation: Because nums[0] + nums[1] == 9
 */
interface Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray
}