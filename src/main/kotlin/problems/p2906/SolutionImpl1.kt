package problems.p2906

class SolutionImpl1 : Solution {
    override fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val mod = 12345
        val n = grid.size
        val m = grid[0].size
        var pref = 1L
        val prefProd = Array(n) { IntArray(m) }
        var suf = 1L
        val sufProd = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                pref = (pref * grid[i][j]) % mod
                prefProd[i][j] = pref.toInt()
                suf = (suf * grid[n - 1 - i][m - 1 - j]) % mod
                sufProd[n - 1 - i][m - 1 - j] = suf.toInt()
            }
        }
        val result = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val l = if (j > 0) prefProd[i][j - 1] else if (i > 0) prefProd[i - 1][m - 1] else 1
                val r = if (j < m - 1) sufProd[i][j + 1] else if (i < n - 1) sufProd[i + 1][0] else 1
                result[i][j] = (l * r) % mod
            }
        }
        return result
    }
}