package problems.p3548

/**
 * **LeetCode Performance:**
 * - Runtime: `42 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `85.42 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/equal-sum-grid-partition-ii/solutions/7696907/kotlin-omn-o42ms-oc-primitives-only-disg-3ex1)
 */
class SolutionImpl2 : Solution {
    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val count = 100_000
        val m = grid.size
        val n = grid[0].size
        val all = IntArray(count + 1)
        var sum = 0L
        for (i in 0 until m)
            for (j in 0 until n) {
                all[grid[i][j]]++
                sum += grid[i][j]
            }

        val top = IntArray(count + 1)
        var needDel = -sum
        for (i in 0 until m - 1) {
            for (j in 0 until n) {
                top[grid[i][j]]++
                needDel += grid[i][j] shl 1
            }
            if (needDel !in -count..count) continue
            val diff = needDel.toInt()
            when {
                diff > 0 -> if (top[diff] > 0 && ((i != 0 && n > 1) || grid[i][0] == diff || grid[0][0] == diff || grid[0][n - 1] == diff)) return true
                diff < 0 -> if (all[-diff] - top[-diff] > 0 && ((i != m - 2 && n > 1) || grid[m - 1][0] == -diff || grid[m - 1][n - 1] == -diff)) return true
                else -> return true
            }
        }

        val left = IntArray(count + 1)
        needDel = -sum
        for (j in 0 until n - 1) {
            for (i in 0 until m) {
                left[grid[i][j]]++
                needDel += grid[i][j] shl 1
            }
            if (needDel !in -count..count) continue
            val diff = needDel.toInt()
            when {
                diff > 0 -> if (left[diff] > 0 && ((j != 0 && m > 1) || grid[0][j] == diff || grid[0][0] == diff || grid[m - 1][0] == diff)) return true
                diff < 0 -> if (all[-diff] - left[-diff] > 0 && ((j != n - 2 && m > 1) || grid[0][n - 1] == -diff || grid[m - 1][n - 1] == -diff)) return true
                else -> return true
            }
        }
        return false
    }
}