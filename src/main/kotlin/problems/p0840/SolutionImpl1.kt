package problems.p0840

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.13 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/pyramid-transition-matrix/solutions/7448359/kotlin-o6n2-53ms-o6n-by-alexeyminkin-bxzb)
 */
class SolutionImpl1 : Solution {

    private val loShu = arrayOf(
        arrayOf(intArrayOf(2, 9, 4), intArrayOf(7, 5, 3), intArrayOf(6, 1, 8)),
        arrayOf(intArrayOf(2, 7, 6), intArrayOf(9, 5, 1), intArrayOf(4, 3, 8)),
        arrayOf(intArrayOf(4, 9, 2), intArrayOf(3, 5, 7), intArrayOf(8, 1, 6)),
        arrayOf(intArrayOf(4, 3, 8), intArrayOf(9, 5, 1), intArrayOf(2, 7, 6)),
        arrayOf(intArrayOf(6, 1, 8), intArrayOf(7, 5, 3), intArrayOf(2, 9, 4)),
        arrayOf(intArrayOf(6, 7, 2), intArrayOf(1, 5, 9), intArrayOf(8, 3, 4)),
        arrayOf(intArrayOf(8, 1, 6), intArrayOf(3, 5, 7), intArrayOf(4, 9, 2)),
        arrayOf(intArrayOf(8, 3, 4), intArrayOf(1, 5, 9), intArrayOf(6, 7, 2)),
    )

    override fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var sum = 0
        for (i in 1 until grid.size - 1) {
            outer@ for (j in 1 until grid[0].size - 1) {
                if (grid[i][j] != 5) continue
                val upLeft = grid[i - 1][j - 1]
                val upRight = grid[i - 1][j + 1]
                val ind = upLeft - 2 + Math.abs(upLeft - upRight) / 2 - 1
                if (ind < 0 || ind > 7) continue
                for (k in 0..2) {
                    for (l in 0..2) {
                        if (grid[i - 1 + k][j - 1 + l] != loShu[ind][k][l]) continue@outer
                    }
                }
                sum++
            }
        }

        return sum
    }
}