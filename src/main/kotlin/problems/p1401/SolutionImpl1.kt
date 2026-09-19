package problems.p1401

/**
 * **LeetCode Performance**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.82 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/circle-and-rectangle-overlapping/solutions/8529189/kotlin-o1-0ms-o1-by-alexeyminkin-pmlr)
 */
class SolutionImpl1 : Solution {
    override fun checkOverlap(r: Int, xC: Int, yC: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val xDist = Math.max(Math.max(x1 - xC, xC - x2), 0)
        val yDist = Math.max(Math.max(y1 - yC, yC - y2), 0)
        return xDist * xDist + yDist * yDist <= r * r
    }
}