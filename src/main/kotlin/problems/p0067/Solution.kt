package problems.p0067

/**
 * **[Add Binary](https://leetcode.com/problems/add-binary/)**
 *
 * **Description:**
 * - Add two binary strings.
 * - Return result as binary string.
 *
 * **Constraints:**
 * - Strings not empty.
 * - Only '0' and '1'.
 * - Length up to 10^4.
 *
 * **Examples:**
 * - Input: a = "11", b = "1"
 * - Output: "100"
 * - Explanation: 3 + 1 = 4 (binary 100)
 */
interface Solution {
    fun addBinary(a: String, b: String): String
}
