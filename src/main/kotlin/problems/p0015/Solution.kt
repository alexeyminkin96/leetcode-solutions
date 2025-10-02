package problems.p0015

/**
 * **[3Sum](https://leetcode.com/problems/3sum/)**
 *
 * **Description:**
 * - Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]`
 *   such that `i != j`, `i != k`, `j != k` and `nums[i] + nums[j] + nums[k] == 0`.
 * - Notice that the solution set must not contain duplicate triplets.
 *
 * **Constraints:**
 * - `3 <= nums.length <= 3000`
 * - `-10^5 <= nums[i] <= 10^5`
 *
 * **Notes:**
 * - The array may contain duplicate values, but the output should include only unique triplets.
 * - Sorting simplifies the detection and skipping of duplicates.
 * - A two-pointer approach is efficient for finding valid triplets.
 *
 * **Examples:**
 * - Input: `[-1,0,1,2,-1,-4]`
 *   Output: `[[-1,-1,2],[-1,0,1]]`
 *   Explanation: Both triplets sum to 0, and no duplicates exist in the output.
 *
 * - Input: `[0,1,1]`
 *   Output: `[]`
 *   Explanation: No triplet sums to 0.
 *
 * - Input: `[0,0,0]`
 *   Output: `[[0,0,0]]`
 *   Explanation: One valid triplet, duplicates are skipped.
 */
interface Solution {
    fun threeSum(nums: IntArray): List<IntArray>
}
