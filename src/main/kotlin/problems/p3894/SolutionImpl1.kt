package problems.p3894

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.98 MB` (Beats `76.92%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/traffic-signal-color/solutions/7873316/kotlin-o1-0ms-o1-by-alexeyminkin-e4wg)
 */
class SolutionImpl1 : Solution {
    override fun trafficSignal(timer: Int): String {
        return when {
            timer == 0 -> "Green"
            timer == 30 -> "Orange"
            timer > 30 && timer <= 90 -> "Red"
            else -> "Invalid"
        }
    }
}