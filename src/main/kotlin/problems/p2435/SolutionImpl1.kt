package problems.p2435

/**
 * **LeetCode Performance:**
 * - Runtime: `50 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `92.33 MB` (Beats `—%` of Kotlin submissions)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/solutions/7376002/kotlin-omnk-60ms-omnk-by-alexeyminkin-wps7)
 */
class SolutionImpl1 : Solution {
    override fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size + 1
        val n = grid[0].size + 1
        val ar = Array(m) { Array(n) { IntArray(k) } }

        ar[1][0][0] = 1

        for (i in 1 until m) {
            for (j in 1 until n) {
                for (t in 0 until k) {
                    ar[i][j][(grid[i - 1][j - 1] + t) % k] = (ar[i][j - 1][t] + ar[i - 1][j][t]) % 1_000_000_007
                }
            }
        }

        return ar[m - 1][n - 1][0]
    }
}
