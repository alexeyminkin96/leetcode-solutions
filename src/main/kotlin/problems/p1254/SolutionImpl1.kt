package problems.p1254

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `53.06 MB` (Beats `19.05%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-closed-islands/solutions/8588043/kotlin-omn-2ms-omn-by-alexeyminkin-5ve8)
 */
class SolutionImpl1 : Solution {
    override fun closedIsland(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        fun dfs(i: Int, j: Int): Boolean {
            if (i < 0 || i == m || j < 0 || j == n) return false
            if (grid[i][j] != 0) return true
            grid[i][j] = 2
            return dfs(i - 1, j) and dfs(i + 1, j) and dfs(i, j - 1) and dfs(i, j + 1)
        }

        var res = 0
        for (i in 0 until m)
            for (j in 0 until n)
                if (grid[i][j] == 0 && dfs(i, j)) res++
        return res
    }
}