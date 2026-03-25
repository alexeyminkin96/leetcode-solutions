package problems.p3546

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `80.32 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/equal-sum-grid-partition-i/solutions/7691346/kotlin-omn-o4ms-o1-in-place-by-alexeymin-p7r4)
 */
class SolutionImpl2 : Solution {
    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        var sum = 0L
        for (i in 0 until m)
            for (j in 0 until n)
                sum += grid[i][j]
        if (sum and 1 == 1L) return false
        sum = sum shr 1
        var row = 0L
        for (i in 0 until m - 1) {
            for (j in 0 until n)
                row += grid[i][j]
            if (row == sum) return true else if (row > sum) break
        }
        var col = 0L
        for (j in 0 until n - 1) {
            for (i in 0 until m)
                col += grid[i][j]
            if (col == sum) return true else if (col > sum) break
        }
        return false
    }
}