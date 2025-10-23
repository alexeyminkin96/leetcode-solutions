package problems.p0027

/**
 * **[Remove Element](https://leetcode.com/problems/remove-element/)**
 *
 * **Description:**
 * - Remove all occurrences of a given value in-place.
 * - Return the new length after removal.
 *
 * **Constraints:**
 * - 0 <= nums.length <= 100
 * - 0 <= nums[i] <= 50
 * - 0 <= val <= 100
 *
 * **Notes:**
 * - Order of remaining elements may change.
 * - Only first k elements are valid after removal.
 *
 * **Examples:**
 * - Input: nums = [3,2,2,3], val = 3
 * - Output: 2
 * - Explanation: [2,2] remain
 */
interface Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int
}
