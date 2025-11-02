package problems.p1526

/**
 * **[Minimum Number of Increments on Subarrays to Form a Target Array](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/)**
 *
 * **Description:**
 * - Given an integer array `target`, return the minimum number of operations needed
 *   to make it from an array of zeros using subarray increment operations.
 * - In each operation, you can increment all elements of any contiguous subarray by 1.
 *
 * **Constraints:**
 * - `1 <= target.length <= 10^5`
 * - `1 <= target[i] <= 10^4`
 *
 * **Examples:**
 * - Input: `[1,2,3,2,1]`
 * - Output: `3`
 * - Explanation: `[0,0,0,0,0] -> [1,1,1,1,1] -> [1,2,2,2,1] -> [1,2,3,2,1]`
 */
interface Solution {
    fun minNumberOperations(target: IntArray): Int
}
