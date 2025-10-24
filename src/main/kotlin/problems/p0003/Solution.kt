package problems.p0003

/**
 * **[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)**
 *
 * **Description:**
 * - Find the length of the longest substring without repeating characters.
 *
 * **Constraints:**
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols, and spaces.
 *
 * **Examples:**
 * - Input: "abcabcbb"
 * - Output: 3
 * - Explanation: "abc" is the longest substring without repeating chars.
 */
interface Solution {
    fun lengthOfLongestSubstring(s: String): Int
}