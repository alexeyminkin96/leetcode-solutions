package problems.p4084

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `246.36 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/last-visited-cell-in-a-directional-grid/solutions/8583573/kotlin-omn-6ms-o1-by-alexeyminkin-l3nd)
 */
class SolutionImpl1 : Solution {
    override fun lastVisitedCell(grid: Array<CharArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        var i = 0
        var j = 0
        while (true) when (grid[i][j]) {
            'U' -> if (i == 0 || grid[i - 1][j] == 'V') break else grid[i--][j] = 'V'
            'D' -> if (i == m - 1 || grid[i + 1][j] == 'V') break else grid[i++][j] = 'V'
            'L' -> if (j == 0 || grid[i][j - 1] == 'V') break else grid[i][j--] = 'V'
            'R' -> if (j == n - 1 || grid[i][j + 1] == 'V') break else grid[i][j++] = 'V'
        }
        return intArrayOf(i, j)
    }
}