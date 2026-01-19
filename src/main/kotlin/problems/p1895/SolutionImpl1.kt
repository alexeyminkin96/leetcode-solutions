package problems.p1895

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `87.50%` of Kotlin submissions)
 * - Memory: `47.26 MB` (Beats `62.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * min(n,m)^2)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/largest-magic-square/solutions/7504764/kotlin-omn2-6ms-omn-by-alexeyminkin-ofru)
 */
class SolutionImpl1 : Solution {
    override fun largestMagicSquare(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val rowsPS = Array(rows) { IntArray(cols + 1) }
        val colsPS = Array(rows + 1) { IntArray(cols) }
        val diags1PS = Array(rows + 1) { IntArray(cols + 1) }
        val diags2PS = Array(rows + 1) { IntArray(cols + 1) }
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                rowsPS[i][j + 1] = rowsPS[i][j] + grid[i][j]
                colsPS[i + 1][j] = colsPS[i][j] + grid[i][j]
                diags1PS[i + 1][j + 1] = diags1PS[i][j] + grid[i][j]
                diags2PS[rows - 1 - i][j + 1] = diags2PS[rows - i][j] + grid[rows - 1 - i][j]
            }
        }
        var side = minOf(rows, cols)
        while (side > 1) {
            for (i in 0..rows - side) {
                out@ for (j in 0..cols - side) {
                    val sum = diags1PS[i + side][j + side] - diags1PS[i][j]
                    if (diags2PS[i][j + side] - diags2PS[i + side][j] != sum) continue@out
                    for (k in 0 until side) {
                        if (rowsPS[i + k][j + side] - rowsPS[i + k][j] != sum) continue@out
                        if (colsPS[i + side][j + k] - colsPS[i][j + k] != sum) continue@out
                    }
                    return side
                }
            }
            side--
        }
        return 1
    }
}