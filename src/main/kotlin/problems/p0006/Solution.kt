package problems.p0006

/**
 * **[Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)**
 *
 * **Description:**
 * - Convert a given string into a zigzag pattern on a given number of rows.
 * - Then read the pattern line by line to form the final string.
 *
 * **Constraints:**
 * - 1 <= s.length <= 1000
 * - s contains only English letters, ',' and '.'
 * - 1 <= numRows <= 1000
 *
 * **Examples:**
 * - Input: s = "PAYPALISHIRING", numRows = 3
 * - Output: "PAHNAPLSIIGYIR"
 * - Explanation: Read zigzag row by row.
 */
interface Solution {
    fun convert(s: String, numRows: Int): String
}