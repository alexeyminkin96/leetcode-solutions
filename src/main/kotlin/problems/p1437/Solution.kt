package problems.p1437

/**
 * **[Check If All 1's Are at Least Length K Places Away](https://leetcode.com/problems/...)**
 *
 * **Description:**
 * - Check if every two 1's have distance >= k
 *
 * **Constraints:**
 * - 1 <= nums.size <= N
 * - nums[i] is 0 or 1
 * - k >= 0
 *
 * **Examples:**
 * - Input: nums=[1,0,0,1], k=2
 * - Output: true
 * - Explanation: gap is 2
 */
interface Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean
}
