package problems.p3643

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `56.27 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(k^2)`
 * - Space: `O(k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/flip-square-submatrix-vertically/solutions/7676722/kotlin-ok2-1ms-o1-by-alexeyminkin-lyjc)
 */
class SolutionImpl1 : Solution {
    override fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for (j in y until y + k) {
            var top = x
            var bot = x + k - 1
            while (top < bot) {
                val buf = grid[top][j]
                grid[top++][j] = grid[bot][j]
                grid[bot--][j] = buf
            }
        }
        return grid
    }
}