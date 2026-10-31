package problems.p3665

class SolutionImpl2 : Solution {
    override fun uniquePaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val nextIFromLeft = Array(m) { IntArray(n) }
        val nextJFromLeft = Array(m) { IntArray(n) }
        val nextIFromTop = Array(m) { IntArray(n) }
        val nextJFromTop = Array(m) { IntArray(n) }

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (grid[i][j] == 0) {
                    nextIFromLeft[i][j] = i
                    nextJFromLeft[i][j] = j
                    nextIFromTop[i][j] = i
                    nextJFromTop[i][j] = j
                } else {
                    if (i == m - 1)
                        nextIFromLeft[i][j] = -1
                    else {
                        nextIFromLeft[i][j] = nextIFromTop[i + 1][j]
                        nextJFromLeft[i][j] = nextJFromTop[i + 1][j]
                    }
                    if (j == n - 1)
                        nextIFromTop[i][j] = -1
                    else {
                        nextIFromTop[i][j] = nextIFromLeft[i][j + 1]
                        nextJFromTop[i][j] = nextJFromLeft[i][j + 1]
                    }
                }
            }
        }

        grid[0][0] = -1

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] >= 0) continue
                val rightI = nextIFromLeft[i][j]
                val rightJ = nextJFromLeft[i][j]
                if (rightI >= 0) {
                    grid[rightI][rightJ] += grid[i][j]
                    if (grid[rightI][rightJ] <= -1_000_000_007) grid[rightI][rightJ] += 1_000_000_007
                }
                val downI = nextIFromTop[i][j]
                val downJ = nextJFromTop[i][j]
                if (downI >= 0) {
                    grid[downI][downJ] += grid[i][j]
                    if (grid[downI][downJ] <= -1_000_000_007) grid[downI][downJ] += 1_000_000_007
                }
            }
        }
        return -grid[m - 1][n - 1]
    }
}