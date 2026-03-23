package problems.p1594

class SolutionImpl1 : Solution {
    override fun maxProductPath(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val max = Array(m) { LongArray(n) }
        max[0][0] = grid[0][0].toLong()
        val min = Array(m) { LongArray(n) }
        min[0][0] = grid[0][0].toLong()
        for (j in 1 until n) {
            min[0][j] = grid[0][j] * min[0][j - 1]
            max[0][j] = min[0][j]
        }
        for (i in 1 until m) {
            min[i][0] = grid[i][0] * min[i - 1][0]
            max[i][0] = min[i][0]
            for (j in 1 until n) {
                val p1 = grid[i][j] * min[i - 1][j]
                val p2 = grid[i][j] * max[i - 1][j]
                val p3 = grid[i][j] * min[i][j - 1]
                val p4 = grid[i][j] * max[i][j - 1]
                min[i][j] = minOf(p1, p2, p3, p4)
                max[i][j] = maxOf(p1, p2, p3, p4)
            }
        }
        return if (max[m - 1][n - 1] < 0) -1 else (max[m - 1][n - 1] % 1_000_000_007).toInt()
    }
}