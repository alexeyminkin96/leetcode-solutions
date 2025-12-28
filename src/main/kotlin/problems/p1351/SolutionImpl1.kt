package problems.p1351

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.00 MB` (Beats `96.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/solutions/7445441/kotlin-onm-0ms-o1-by-alexeyminkin-e9oi)
 */
class SolutionImpl1 : Solution {
    override fun countNegatives(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var result = m * n
        var j = n - 1

        for (i in 0 until m) {
            if (grid[i][0] < 0) break
            while (grid[i][j] < 0) j--
            result -= j + 1
        }
        return result
    }
}