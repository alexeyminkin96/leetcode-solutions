package problems.p1930

/**
 * **[Unique Length-3 Palindromic Subsequences](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)**
 *
 * **Description:**
 * - Count unique palindromes from string size of 3 chars
 *
 * **Constraints:**
 * - 3 <= s.length <= 100000
 * - Only lowercase English chars
 *
 * **Examples:**
 * - Input: "aabca" → Output: 3
 * - Palindromes: "aba", "aaa", "aca"
 */
interface Solution {
    fun countPalindromicSubsequence(s: String): Int
}
