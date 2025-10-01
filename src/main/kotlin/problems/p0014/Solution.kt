package problems.p0014

/**
 * **[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)**
 *
 * **Description:**
 * - Write a function to find the longest common prefix string amongst an array of strings.
 * - If there is no common prefix, return an empty string "".
 *
 * **Constraints:**
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters.
 *
 * **Notes:**
 * - The solution must handle edge cases like empty strings and no common prefix.
 *
 * **Examples:**
 * - Input: ["flower","flow","flight"]
 *   Output: "fl"
 *   Explanation: "fl" is the longest common prefix.
 *
 * - Input: ["dog","racecar","car"]
 *   Output: ""
 *   Explanation: There is no common prefix among the strings.
 */
interface Solution {
    fun longestCommonPrefix(strs: Array<String>): String
}
