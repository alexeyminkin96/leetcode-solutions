package problems.p3546

class SolutionImpl1 : Solution {
    override fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val rows = LongArray(m)
        val cols = LongArray(n)
        var sum = 0L
        for (i in 0 until m) {
            for (j in 0 until n) {
                rows[i] += grid[i][j].toLong()
                cols[j] += grid[i][j].toLong()
                sum += grid[i][j]
            }
        }
        if (sum and 1 == 1L) return false

        var row = sum shr 1
        var i = 0
        while (row > 0) row -= rows[i++]
        if (row == 0L) return true

        var col = sum shr 1
        var j = 0
        while (col > 0) col -= cols[j++]
        if (col == 0L) return true
        return false
    }
}