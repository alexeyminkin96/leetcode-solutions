package problems.p0009

/**
 * **[Palindrome Number](https://leetcode.com/problems/palindrome-number/)**
 *
 * **Description:**
 * - Check if integer reads same forward and backward.
 *
 * **Constraints:**
 * - `-2^31 <= x <= 2^31 - 1`
 * - No string convert allowed (optional in problem).
 *
 * **Examples:**
 * - Input: 121 → Output: true
 * - Input: -121 → Output: false
 * - Input: 10 → Output: false
 * - Explanation: last digit zero breaks symmetry.
 */
interface Solution {
    fun isPalindrome(x: Int): Boolean
}
