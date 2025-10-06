package problems.p0007

/**
 * **[Reverse Integer](https://leetcode.com/problems/reverse-integer/)**
 *
 * **Description:**
 * - Reverse digits of a 32-bit signed integer.
 * - Return 0 if the reversed value overflows Int range.
 *
 * **Constraints:**
 * - -2³¹ <= x <= 2³¹ - 1
 *
 * **Example:**
 * - Input: x = 123 → Output: 321
 * - Input: x = -123 → Output: -321
 * - Input: x = 120 → Output: 21
 * - Input: x = 1534236469 → Output: 0 (overflow)
 */
interface Solution {
    fun reverse(x: Int): Int
}