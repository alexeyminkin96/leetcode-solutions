package problems.p3289

/**
 * **[The Two Sneaky Numbers of Digitville](https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/)**
 *
 * **Description:**
 * - In a list of numbers from 0 to n, two numbers appear twice.
 * - Find and return both duplicated numbers in ascending order.
 *
 * **Constraints:**
 * - 2 <= n <= 100
 * - nums.length == n + 2
 * - 0 <= nums[i] <= n
 * - Exactly two numbers appear twice.
 *
 * **Examples:**
 * - Input: [0,1,1,2,3,3]
 * - Output: [1,3]
 * - Explanation: 1 and 3 are repeated twice.
 */
interface Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray
}
