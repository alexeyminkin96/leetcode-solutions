package problems.p3418

class SolutionImpl1 : Solution {
    override fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val frid0 = Array(m + 1) { IntArray(n + 1) { -1_000_000 } }; frid0[0][1] = 0
        val frid1 = Array(m + 1) { IntArray(n + 1) { -1_000_000 } }; frid1[0][1] = 0
        val frid2 = Array(m + 1) { IntArray(n + 1) { -1_000_000 } }; frid2[0][1] = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                val cur = coins[i][j]
                frid0[i + 1][j + 1] = maxOf(frid0[i][j + 1] + cur, frid0[i + 1][j] + cur)
                frid1[i + 1][j + 1] = maxOf(
                    frid0[i][j + 1], frid0[i + 1][j], frid1[i][j + 1] + cur, frid1[i + 1][j] + cur
                )
                frid2[i + 1][j + 1] = maxOf(
                    frid1[i][j + 1], frid1[i + 1][j], frid2[i][j + 1] + cur, frid2[i + 1][j] + cur
                )
            }
        }
        return maxOf(frid0[m][n], frid1[m][n], frid2[m][n])
    }
}
