package problems.p0013

/**
 * **[Roman to Integer](https://leetcode.com/problems/roman-to-integer/)**
 *
 * **Description:**
 * - Convert a Roman numeral string to an integer.
 *
 * **Constraints:**
 * - 1 <= s.length <= 15
 * - s contains valid Roman numerals ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 *
 * **Examples:**
 * - Input: "MCMXCIV"
 * - Output: 1994
 * - Explanation: M(1000) + CM(900) + XC(90) + IV(4)
 */
interface Solution {
    fun romanToInt(s: String): Int
}