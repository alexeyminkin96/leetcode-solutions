package problems.p3370

/**
 * **[Smallest Number With All Set Bits](https://leetcode.com/problems/smallest-number-with-all-set-bits/)**
 *
 * **Description:**
 * - Given a positive integer n, return the smallest number x such that:
 *   - x >= n
 *   - The binary representation of x contains only set bits (1s).
 *
 * **Constraints:**
 * - 1 <= n <= 1000
 *
 * **Examples:**
 * - Input: n = 5 → Output: 7 (111₂)
 * - Input: n = 10 → Output: 15 (1111₂)
 * - Input: n = 3 → Output: 3 (11₂)
 */
interface Solution {
    fun smallestNumber(n: Int): Int
}
