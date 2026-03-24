package problems.p2906

class SolutionImpl3 : Solution {
    override fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val mod = 12345
        val n = grid.size
        val m = grid[0].size
        val sufProd = IntArray(n * m + 1); sufProd[n * m] = 1
        for (i in n - 1 downTo 0)
            for (j in m - 1 downTo 0)
                sufProd[i * m + j] = ((sufProd[i * m + j + 1].toLong() * grid[i][j]) % mod).toInt()
        var pref = 1L
        return Array(n) { i ->
            IntArray(m) { j ->
                val res = ((pref * sufProd[i * m + j + 1]) % mod).toInt()
                pref = (pref * grid[i][j]) % mod
                res
            }
        }
    }
}