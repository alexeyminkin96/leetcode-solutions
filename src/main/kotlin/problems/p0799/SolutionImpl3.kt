package problems.p0799

class SolutionImpl3 : Solution {
    private val scale = 100_000L
    override fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val row = LongArray(100)
        row[0] = poured * scale
        for (i in 0 until query_row) {
            for (j in i downTo 0) {
                row[j] = Math.max(row[j] - scale, 0)
                row[j] /= 2L
                row[j + 1] += row[j]
            }
        }
        return Math.min(row[query_glass] / scale.toDouble(), 1.toDouble())
    }
}