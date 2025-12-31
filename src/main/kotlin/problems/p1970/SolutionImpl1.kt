package problems.p1970

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `77.40 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(row * col)`
 * - Space: `O(row * col)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/last-day-where-you-can-still-cross/solutions/7452584/kotlin-orowcol-10ms-orowcol-continuous-r-x46u)
 */
class SolutionImpl1 : Solution {
    override fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        val grid = Array(row) { IntArray(col) }
        for (i in 0 until cells.size) {
            val y = cells[i][0] - 1
            val x = cells[i][1] - 1
            setValue(y, x, row, col, grid)
            if (propagateValue(y, x, row, col, grid)) return i
        }
        return 0
    }

    private fun setValue(y: Int, x: Int, row: Int, col: Int, grid: Array<IntArray>) {
        when (x) {
            0 -> grid[y][x] = 2
            col - 1 -> grid[y][x] = 3
            else -> {
                for (i in 0..2) {
                    for (j in 0..2) {
                        val yi = y - 1 + i
                        val xj = x - 1 + j
                        if (yi in 0..<row && grid[yi][xj] > 1) {
                            grid[y][x] = grid[yi][xj]
                            return
                        }
                    }
                }
                grid[y][x] = 1
            }
        }
    }

    private fun propagateValue(y: Int, x: Int, row: Int, col: Int, grid: Array<IntArray>): Boolean {
        if (grid[y][x] < 2) return false
        for (i in 0..2) {
            for (j in 0..2) {
                val yi = y - 1 + i
                val xj = x - 1 + j
                if (yi in 0..<row && xj in 0..<col) {
                    when (grid[yi][xj]) {
                        1 -> {
                            grid[yi][xj] = grid[y][x]
                            if (propagateValue(yi, xj, row, col, grid)) return true
                        }

                        2, 3 -> {
                            if (grid[y][x] != grid[yi][xj]) return true
                        }
                    }
                }
            }
        }
        return false
    }
}