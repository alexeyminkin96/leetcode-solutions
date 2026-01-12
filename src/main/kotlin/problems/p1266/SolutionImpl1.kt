package problems.p1266

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.08 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-time-visiting-all-points/solutions/7488236/kotlin-on-1ms-o1-by-alexeyminkin-rx0j)
 */
class SolutionImpl1 : Solution {
    override fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var result = 0
        for (i in 1 until points.size) {
            result += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]))
        }
        return result
    }
}