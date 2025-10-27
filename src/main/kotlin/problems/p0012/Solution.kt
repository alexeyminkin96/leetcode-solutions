package problems.p0012

/**
 * **[Integer to Roman](https://leetcode.com/problems/integer-to-roman/)**
 *
 * **Description:**
 * - Convert an integer to a Roman numeral.
 * - Uses standard Roman numeral symbols and subtraction rules.
 *
 * **Constraints:**
 * - 1 <= num <= 3999
 *
 * **Examples:**
 * - Input: num = 58
 * - Output: "LVIII"
 * - Explanation: L = 50, V = 5, III = 3
 */
interface Solution {
    fun intToRoman(num: Int): String
}