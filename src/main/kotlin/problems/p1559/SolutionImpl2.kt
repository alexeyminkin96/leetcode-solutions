package problems.p1559

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `83.82 MB` (Beats `98.46%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/detect-cycles-in-2d-grid/solutions/8107710/kotlin-omn-6ms-omn-by-alexeyminkin-4au6)
 */
class SolutionImpl2 : Solution {
    override fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val un = IntArray(m * n) { it }
        fun find(x: Int): Int {
            if (un[x] != x) un[x] = find(un[x])
            return un[x]
        }

        fun union(a: Int, b: Int): Boolean {
            val pa = find(a)
            val pb = find(b)
            un[pa] = pb
            return pa == pb
        }

        for (i in 0 until m)
            for (j in 0 until n) {
                if (j > 0 && grid[i][j] == grid[i][j - 1] && union(i * n + j, i * n + (j - 1))) return true
                if (i > 0 && grid[i][j] == grid[i - 1][j] && union(i * n + j, (i - 1) * n + j)) return true
            }
        return false
    }
}