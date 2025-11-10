package problems.p0034

/**
 * **[Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)**
 *
 * **Description:**
 * - Given a sorted array `nums` and a target value, find the starting and ending position of the target.
 * - If the target is not found, return `[-1, -1]`.
 *
 * **Constraints:**
 * - `0 <= nums.length <= 10^5`
 * - `-10^9 <= nums[i], target <= 10^9`
 * - `nums` is non-decreasing.
 *
 * **Notes:**
 * - The solution must run in `O(log n)` time.
 *
 * **Examples:**
 * - Input: `nums = [5,7,7,8,8,10], target = 8`
 * - Output: `[3,4]`
 * - Explanation: Target `8` appears from index `3` to `4`.
 */
interface Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray
}
