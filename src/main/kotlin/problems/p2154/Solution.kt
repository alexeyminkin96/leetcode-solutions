package problems.p2154

/**
 * **[Keep Multiplying Found Values by Two](https://leetcode.com/problems/keep-multiplying-found-values-by-two/)**
 *
 * **Description:**
 * - Start with given `original`.
 * - If `original` exists in `nums`, multiply it by 2.
 * - Repeat while number is found.
 * - Return final value.
 *
 * **Constraints:**
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i], original <= 1000
 *
 * **Examples:**
 * - Input: nums = [5,3,6,1,12], original = 3
 * - Output: 24
 * - Explanation: 3→6→12→24
 *
 * - Input: nums = [2,7,9], original = 4
 * - Output: 4
 * - Explanation: 4 not found
 */
interface Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int
}
