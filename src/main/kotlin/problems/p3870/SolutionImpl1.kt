package problems.p3870

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.70 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-commas-in-range/solutions/8509085/kotlin-o1-0ms-o1-by-alexeyminkin-vqth)
 */
class SolutionImpl1 : Solution {
    override fun countCommas(n: Int): Int {
        return Math.max(n - 999, 0)
    }
}