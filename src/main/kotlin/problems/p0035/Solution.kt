package problems.p0035

/**
 * **[Search Insert Position](https://leetcode.com/problems/search-insert-position/)**
 *
 * **Description:**
 * - Find position of `target` in sorted array `nums`.
 * - If not found, return position where it should be inserted.
 *
 * **Constraints:**
 * - 1 <= nums.length <= 10⁴
 * - -10⁴ <= nums[i] <= 10⁴
 * - nums is sorted in ascending order
 * - -10⁴ <= target <= 10⁴
 *
 * **Examples:**
 * - Input: nums = [1,3,5,6], target = 5
 * - Output: 2
 * - Input: nums = [1,3,5,6], target = 2
 * - Output: 1
 */
interface Solution {
    fun searchInsert(nums: IntArray, target: Int): Int
}
