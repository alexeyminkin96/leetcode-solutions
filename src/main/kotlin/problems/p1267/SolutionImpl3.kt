package problems.p1267

class SolutionImpl3 : Solution {
    override fun countServers(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        fun columnCount(j: Int): Int {
            var count = 0
            for (i in 0 until m)
                count += grid[i][j]
            return count
        }

        var res = 0
        for (i in 0 until m) {
            var rowCount = 0
            var lastJ = -1
            for (j in 0 until n) {
                if (grid[i][j] == 0) continue
                rowCount++
                lastJ = j
            }
            if (rowCount != 1 || columnCount(lastJ) > 1) res += rowCount
        }

        return res
    }
}