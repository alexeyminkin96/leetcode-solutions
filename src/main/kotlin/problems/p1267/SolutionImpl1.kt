package problems.p1267

class SolutionImpl1 : Solution {
    override fun countServers(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val colCounts = IntArray(n)
        var res = 0
        for (i in 0 until m)
            for (j in 0 until n)
                colCounts[j] += grid[i][j]

        for (i in 0 until m) {
            var rowCount = 0
            var lastJ = -1
            for (j in 0 until n) {
                if (grid[i][j] == 0) continue
                rowCount++
                lastJ = j
            }
            if (rowCount != 1 || colCounts[lastJ] > 1) res += rowCount
        }

        return res
    }
}