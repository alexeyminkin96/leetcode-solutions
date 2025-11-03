package problems.p1578

/**
 * **[1578. Minimum Time to Make Rope Colorful](https://leetcode.com/problems/minimum-time-to-make-rope-colorful/)**
 *
 * **Description:**
 * - Given a rope of colors and an array of times, remove balloons so that no two adjacent have the same color.
 * - Each removal costs `neededTime[i]`.
 * - Return the minimum total cost.
 *
 * **Constraints:**
 * - `1 <= colors.length == neededTime.length <= 10^5`
 * - `1 <= neededTime[i] <= 10^4`
 * - `colors` contains only lowercase English letters.
 *
 * **Examples:**
 * - Input: `colors = "abaac", neededTime = [1,2,3,4,5]`
 * - Output: `3`
 * - Explanation: Remove balloon at index 2 (time 3).
 */
interface Solution {
    fun minCost(colors: String, neededTime: IntArray): Int
}
