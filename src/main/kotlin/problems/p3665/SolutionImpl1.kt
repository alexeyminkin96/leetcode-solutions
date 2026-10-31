package problems.p3665

class SolutionImpl1 : Solution {
    override fun uniquePaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        grid[0][0] = -1

        fun updateNext(i: Int, j: Int, dir: Int, sum: Int) {
            var nextI = i
            var nextJ = j
            var dir = dir
            while (nextI < m && nextJ < n && grid[nextI][nextJ] == 1) {
                nextI += dir
                dir = 1 - dir
                nextJ += dir
            }
            if (nextI < m && nextJ < n) {
                grid[nextI][nextJ] += sum
                if (grid[nextI][nextJ] <= -1_000_000_007) grid[nextI][nextJ] += 1_000_000_007
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] >= 0) continue
                updateNext(i, j + 1, 1, grid[i][j])
                updateNext(i + 1, j, 0, grid[i][j])
            }
        }
        return -grid[m - 1][n - 1]
    }
}