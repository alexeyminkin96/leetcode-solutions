package problems.p3665

/**
 * **LeetCode Performance**
 * - Runtime: `21 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `250.78 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(m × n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/twisted-mirror-path-count/solutions/8596415/kotlin-omn-21ms-on-by-alexeyminkin-qllb)
 */
class SolutionImpl3 : Solution {
    override fun uniquePaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dpLeft = IntArray(n + 1)
        val dpTop = IntArray(n + 1)
        dpLeft[1] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    dpTop[j + 1] = dpLeft[j + 1]
                    dpLeft[j + 1] = dpTop[j]
                } else {
                    var s = dpLeft[j + 1] + dpTop[j]
                    if (s >= 1_000_000_007) s -= 1_000_000_007
                    dpLeft[j + 1] = s
                    dpTop[j + 1] = s
                }
            }
        }
        return dpLeft[n]
    }
}