package problems.p1344

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.79 MB` (Beats `89.66%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/angle-between-hands-of-a-clock/solutions/8343424/kotlin-o1-0ms-o1-by-alexeyminkin-6ugz)
 */
class SolutionImpl1 : Solution {
    override fun angleClock(hour: Int, minutes: Int): Double {
        val angle = Math.abs(hour * 30 - minutes * 5.5)
        return Math.min(angle, 360 - angle)
    }
}