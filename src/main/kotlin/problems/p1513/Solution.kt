package problems.p1513

/**
 * **[Number of Substrings With Only 1s](https://leetcode.com/problems/number-of-substrings-with-only-1s/)**
 *
 * **Description:**
 * - Count substrings made only from '1'
 * - Every group of consecutive '1' adds k*(k+1)/2 substrings
 *
 * **Constraints:**
 * - 1 <= s.length <= 1e5
 * - s[i] is '0' or '1'
 *
 * **Notes:**
 * - Large result, return modulo 1e9+7
 *
 * **Examples:**
 * - Input: "0110111"
 * - Output: 9
 * - Explanation: count all substrings of 1-blocks
 */
interface Solution {
    fun numSub(s: String): Int
}
