package problems.p0048

class SolutionImpl2 : Solution {
    override fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n)
            for (j in 0 until n)
                matrix[j][n - 1 - i] = (matrix[j][n - 1 - i] and 0xFFFF) or (matrix[i][j] shl 16)
        for (i in 0 until n)
            for (j in 0 until n)
                matrix[i][j] = matrix[i][j] shr 16
    }
}