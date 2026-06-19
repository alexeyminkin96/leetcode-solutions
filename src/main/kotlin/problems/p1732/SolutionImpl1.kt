package problems.p1732

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.20 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-highest-altitude/solutions/8345884/kotlin-on-0ms-o1-by-alexeyminkin-jsb1)
 */
class SolutionImpl1 : Solution {
    override fun largestAltitude(gain: IntArray): Int {
        var h = 0
        var max = 0
        for (g in gain) {
            h += g
            max = Math.max(max, h)
        }
        return max
    }
}