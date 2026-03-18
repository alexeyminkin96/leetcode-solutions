package problems.p3070

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `141.13 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/solutions/7656358/kotlin-omn-3ms-o1-2d-prefix-sum-in-place-px1a)
 */
class SolutionImpl1 : Solution {
    override fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        var count = if (grid[0][0] > k) return 0 else 1
        for (j in 1 until grid[0].size) {
            grid[0][j] += grid[0][j - 1]
            if (grid[0][j] > k) break else count++
        }
        for (i in 1 until grid.size) {
            grid[i][0] += grid[i - 1][0]
            if (grid[i][0] > k) break else count++
            for (j in 1 until grid[0].size) {
                grid[i][j] += grid[i][j - 1] + grid[i - 1][j] - grid[i - 1][j - 1]
                if (grid[i][j] > k) break else count++
            }
        }
        return count
    }
}