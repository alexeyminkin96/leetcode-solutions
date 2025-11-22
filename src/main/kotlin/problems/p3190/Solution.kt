package problems.p3190

/**
 * **[Find Minimum Operations to Make All Elements Divisible by Three](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/)**
 *
 * **Description:**
 * - Each operation is +1 or -1 on any element
 * - Goal: make every number divisible by 3
 *
 * **Constraints:**
 * - 1 <= nums.length <= 50
 * - 1 <= nums[i] <= 50
 *
 * **Examples:**
 * - Input: [1,2,3,4]
 * - Output: 3
 * - Explanation: adjust each non-divisible element once
 */
interface Solution {
    fun minimumOperations(nums: IntArray): Int
}
