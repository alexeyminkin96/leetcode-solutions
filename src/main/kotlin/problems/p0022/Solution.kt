package problems.p0022

/**
 * **[Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)**
 *
 * **Description:**
 * - Generate all valid parentheses strings made of `n` pairs `()`.
 *
 * **Constraints:**
 * - `1 <= n <= 8`
 *
 * **Examples:**
 * - Input: `n = 3`
 * - Output: `["((()))","(()())","(())()","()(())","()()()"]`
 * - Explanation: all valid length-6 combinations.
 */
interface Solution {
    fun generateParenthesis(n: Int): List<String>
}

