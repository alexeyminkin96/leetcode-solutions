package problems.p0011

/**
 * **[Container With Most Water](https://leetcode.com/problems/container-with-most-water/)**
 *
 * **Description:**
 * - Given an array of heights, find two lines that together with the x-axis form a container
 *   such that the container holds the most water.
 *
 * **Constraints:**
 * - 2 <= height.length <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * **Notes:**
 * - The water area is limited by the shorter line.
 *
 * **Examples:**
 * - Input: height = [1,8,6,2,5,4,8,3,7]
 * - Output: 49
 * - Explanation: Max area between lines 2 and 9.
 */
interface Solution {
    fun maxArea(height: IntArray): Int
}