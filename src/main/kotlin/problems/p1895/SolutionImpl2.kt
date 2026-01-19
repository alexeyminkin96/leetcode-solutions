package problems.p1895

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `87.50%` of Kotlin submissions)
 * - Memory: `47.69 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * min(n,m))`
 * - Space: `O(m * n)`
 */
class SolutionImpl2 : Solution {
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
        val approved = Array(rows) { IntArray(cols) }
        while (side > 1) {
            for (i in 0..rows - side) {
                var start = 0
                var sum = colsPS[i + side][start] - colsPS[i][start]
                for (j in 1 until cols) {
                    val cur = colsPS[i + side][j] - colsPS[i][j]
                    if (cur == sum) {
                        val left = j - side + 1
                        if (left >= start)
                            approved[i][left] = sum
                    } else {
                        start = j
                        sum = cur
                    }
                }
            }
            for (j in 0..cols - side) {
                var start = 0
                var sum = rowsPS[start][j + side] - rowsPS[start][j]
                for (i in 1 until rows) {
                    val cur = rowsPS[i][j + side] - rowsPS[i][j]
                    val top = i - side + 1
                    if (cur == sum) {
                        if (top >= start
                            && approved[top][j] == sum
                            && diags1PS[top + side][j + side] - diags1PS[top][j] == sum
                            && diags2PS[top][j + side] - diags2PS[top + side][j] == sum
                        ) return side
                    } else {
                        start = i
                        sum = cur
                    }
                    if (top >= start)
                        approved[top][j] = 0
                }
            }
            side--
        }
        return 1
    }
}