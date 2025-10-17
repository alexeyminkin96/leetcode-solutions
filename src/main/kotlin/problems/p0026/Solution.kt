package problems.p0026

/**
 * **[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)**
 *
 * **Description:**
 * - Remove duplicates from sorted array in-place.
 *
 * **Constraints:**
 * - 1 <= nums.length <= 3 * 10⁴
 * - -10⁴ <= nums[i] <= 10⁴
 * - nums is sorted in non-decreasing order.
 *
 * **Examples:**
 * - Input: [1,1,2]
 * - Output: 2 → [1,2,_]
 */
interface Solution {
    fun removeDuplicates(nums: IntArray): Int
}
