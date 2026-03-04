package problems.p1582

class SolutionImpl1 : Solution {
    override fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rows = IntArray(m)
        val cols = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    rows[i]++
                    cols[j]++
                }
            }
        }
        var count = 0
        for (i in 0 until m) {
            if (rows[i] != 1) continue
            for (j in 0 until n)
                if (cols[j] == 1 && mat[i][j] == 1) count++
        }
        return count
    }
}