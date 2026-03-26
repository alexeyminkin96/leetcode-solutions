package problems.p3548

class SolutionImpl3 : Solution {
    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val count = 100_000
        val m = grid.size
        val n = grid[0].size
        val gridFlip = Array(n) { IntArray(m) }
        val all = IntArray(count + 1)
        var sum = 0L
        for (i in 0 until m)
            for (j in 0 until n) {
                sum += grid[i][j]
                all[grid[i][j]]++
                gridFlip[j][i] = grid[i][j]
            }
        return canPartitionVertical(sum, grid, all) || canPartitionVertical(sum, gridFlip, all)
    }

    private fun canPartitionVertical(sum: Long, grid: Array<IntArray>, all: IntArray): Boolean {
        val count = 100_000
        val m = grid.size
        val n = grid[0].size
        val top = IntArray(count + 1)
        var needDel = -sum
        for (i in 0 until m - 1) {
            for (j in 0 until n) {
                needDel += grid[i][j] shl 1
                top[grid[i][j]]++
            }
            if (needDel !in -count..count) continue
            val diff = needDel.toInt()
            when {
                diff > 0 -> if (top[diff] > 0 && ((i != 0 && n > 1) || grid[i][0] == diff || grid[0][0] == diff || grid[0][n - 1] == diff)) return true
                diff < 0 -> if (all[-diff] - top[-diff] > 0 && ((i != m - 2 && n > 1) || grid[m - 1][0] == -diff || grid[m - 1][n - 1] == -diff)) return true
                else -> return true
            }
        }
        return false
    }
}