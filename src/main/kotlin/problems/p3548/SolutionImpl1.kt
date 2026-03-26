package problems.p3548

/**
 * Incorrect
 */
class SolutionImpl1 : Solution {
    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        var sum = 0L
        for (i in 0 until m)
            for (j in 0 until n)
                sum += grid[i][j]

        var row = -1
        var rowSum = 0L
        var topDel = -sum
        while (topDel < 0) {
            row++
            rowSum = 0L
            for (j in 0 until n)
                rowSum += grid[row][j] shl 1
            topDel += rowSum
        }
        if (topDel == 0L) return true
        val butDel = rowSum - topDel
        for (i in 0 until m)
            for (j in 0 until n) {
                if (i <= row && grid[i][j].toLong() == topDel && (j == 0 || j == n - 1 || row != 0)) return true
                if (i >= row && grid[i][j].toLong() == butDel && (j == 0 || j == n - 1 || row != m - 1)) return true
            }

        var col = -1
        var colSum = 0L
        var leftDel = -sum
        while (leftDel < 0) {
            col++
            colSum = 0L
            for (i in 0 until m)
                colSum += grid[i][col] shl 1
            leftDel += colSum
        }
        if (leftDel == 0L) return true
        val rightDel = colSum - leftDel
        for (j in 0 until n)
            for (i in 0 until m) {
                if (j <= col && grid[i][j].toLong() == leftDel && (i == 0 || i == m - 1 || col != 0)) return true
                if (j >= col && grid[i][j].toLong() == rightDel && (i == 0 || i == m - 1 || col != n - 1)) return true
            }
        return false
    }
}