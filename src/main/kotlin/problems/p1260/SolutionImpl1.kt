package problems.p1260

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.63 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/shift-2d-grid/solutions/8408599/kotlin-omn-2ms-o1-by-alexeyminkin-85wt)
 */
class SolutionImpl1 : Solution {
    override fun shiftGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val all = m * n
        val k = k % all
        return Array(m) { i ->
            IntArray(n) { j ->
                val prev = (i * n + j - k + all) % all
                grid[prev / n][prev % n]
            }
        }
    }
}