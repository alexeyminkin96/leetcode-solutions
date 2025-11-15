package problems.p0028

/**
 * **[Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)**
 *
 * **Description:**
 * - Return the first index where `needle` appears in `haystack`
 * - If no occurrence, return `-1`
 *
 * **Constraints:**
 * - 1 <= haystack.length <= 10⁴
 * - 1 <= needle.length <= 10⁴
 * - haystack and needle contain only lowercase English letters
 *
 * **Examples:**
 * - Input: haystack = "sadbutsad", needle = "sad"
 * - Output: 0
 * - Explanation: first match starts at index 0
 *
 * - Input: haystack = "leetcode", needle = "leeto"
 * - Output: -1
 * - Explanation: substring does not exist
 */
interface Solution {
    fun strStr(haystack: String, needle: String): Int
}
