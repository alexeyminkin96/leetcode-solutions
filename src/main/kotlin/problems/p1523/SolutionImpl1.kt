package problems.p1523

/**
 * **LeetCode Performance:**
 * - Runtime: `61 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `35.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/solutions/7397747/kotlin-o1-61ms-o1-by-alexeyminkin-uasv)
 */
class SolutionImpl1 : Solution {
    override fun countOdds(low: Int, high: Int): Int {
        return (high + 1 + (high and 1) - low) shr 1
    }
}