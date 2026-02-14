package problems.p0799

class SolutionImpl1 : Solution {
    override fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val rows = Array(100) { DoubleArray(100) }
        rows[0][0] = poured.toDouble()
        for (i in 0 until query_row) {
            for (j in 0..i) {
                rows[i][j] = Math.max(rows[i][j] - 1, 0.toDouble())
                rows[i + 1][j] += rows[i][j] / 2
                rows[i + 1][j + 1] += rows[i][j] / 2
            }
        }
        return Math.min(rows[query_row][query_glass], 1.toDouble())
    }
}