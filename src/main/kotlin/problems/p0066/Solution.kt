package problems.p0066

/**
 * **[Plus One](https://leetcode.com/problems/plus-one/)**
 *
 * **Description:**
 * - Given an array representing a non-negative integer, add one to it.
 * - Digits are stored from most to least significant.
 * - Return the resulting array of digits.
 *
 * **Constraints:**
 * - 1 <= digits.length <= 100
 * - 0 <= digits[i] <= 9
 * - No leading zeros in input.
 *
 * **Examples:**
 * - Input: [1,2,3]
 * - Output: [1,2,4]
 * - Explanation: 123 + 1 = 124
 */
interface Solution {
    fun plusOne(digits: IntArray): IntArray
}
