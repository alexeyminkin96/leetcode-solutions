package problems.p0020

/**
 * **[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)**
 *
 * **Description:**
 * - Determine if the input string of parentheses is valid.
 * - Every opening bracket must be closed by the same type and in correct order.
 *
 * **Constraints:**
 * - 1 <= s.length <= 10⁴
 * - s consists of only '()[]{}'
 *
 * **Example:**
 * - Input: s = "()[]{}"
 * - Output: true
 * - Input: s = "(]"
 * - Output: false
 */
interface Solution {
    fun isValid(s: String): Boolean
}
