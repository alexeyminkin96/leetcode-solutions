package problems.p3619

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `172.96 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/solutions/8589577/kotlin-omn-14ms-omn-by-alexeyminkin-284a)
 */
class SolutionImpl1 : Solution {
    override fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        fun valueIsland(i: Int, j: Int): Long {
            if (i < 0 || i == m || j < 0 || j == n) return 0
            val value = grid[i][j]
            if (value == 0) return 0
            grid[i][j] = 0
            return value +
                valueIsland(i - 1, j) +
                valueIsland(i + 1, j) +
                valueIsland(i, j - 1) +
                valueIsland(i, j + 1)
        }

        var res = 0
        for (i in 0 until m)
            for (j in 0 until n)
                if (grid[i][j] != 0 && valueIsland(i, j) % k == 0L) res++
        return res
    }
}