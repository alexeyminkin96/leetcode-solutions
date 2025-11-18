package problems.p0717

/**
 * **[One Bit and Two Bit Characters](https://leetcode.com/problems/one-bit-and-two-bit-characters/)**
 *
 * **Description:**
 * - Check if last char is 1-bit or 2-bit encoded
 *
 * **Constraints:**
 * - bits[i] is 0 or 1
 * - Last bit always 0
 *
 * **Examples:**
 * - Input: [1,0,0]
 * - Output: true
 * - Explanation: last char is single bit
 */
interface Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean
}
