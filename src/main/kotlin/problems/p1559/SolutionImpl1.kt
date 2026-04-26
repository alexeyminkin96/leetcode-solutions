package problems.p1559

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `93.85%` of Kotlin submissions)
 * - Memory: `87.97 MB` (Beats `93.85%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 */
class SolutionImpl1 : Solution {
    override fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size

        fun dfs(i: Int, j: Int, pi: Int, pj: Int, c: Char): Boolean {
            grid[i][j] = c + 26
            for (d in 0..3) {
                var ni = i
                var nj = j
                if (d and 1 == 1) ni -= 2 - d else nj -= 1 - d
                if (ni == pi && nj == pj) continue
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue
                if (grid[ni][nj] == c + 26) return true
                if (grid[ni][nj] != c) continue
                if (dfs(ni, nj, i, j, c)) return true
            }
            return false
        }

        for (i in 0 until m)
            for (j in 0 until n)
                if (grid[i][j] <= 'z' && dfs(i, j, -1, -1, grid[i][j])) return true
        return false
    }
}