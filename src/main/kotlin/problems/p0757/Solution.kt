package problems.p0757

/**
 * **[Set Intersection Size At Least Two](https://leetcode.com/problems/set-intersection-size-at-least-two)**
 *
 * **Description:**
 * - Pick numbers on number line
 * - Each interval must contain at least two picked numbers
 * - Goal: use minimum numbers
 *
 * **Constraints:**
 * - 1 <= intervals.length <= 3000
 * - 0 <= start < end <= 1e8
 *
 * **Examples:**
 * - Input: [[1,3],[3,7],[8,9]]
 * - Output: 5
 * - Explanation: every interval has >= 2 numbers
 */
interface Solution {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int
}
