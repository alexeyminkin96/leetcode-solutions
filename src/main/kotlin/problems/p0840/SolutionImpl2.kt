package problems.p0840

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.39 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var sum = 0
        for (i in 1 until grid.size - 1) {
            outer@ for (j in 1 until grid[0].size - 1) {
                if (grid[i][j] != 5) continue
                var bits = 0
                for (k in 0..2) {
                    var verSum = 0
                    var gorSum = 0
                    for (l in 0..2) {
                        val el = grid[i - 1 + k][j - 1 + l]
                        if (el < 1 || el - 1 > 8) continue@outer
                        if ((1 shl el) and bits != 0) continue@outer
                        bits = bits or (1 shl el)
                        verSum += el
                        gorSum += grid[i - 1 + l][j - 1 + k]
                    }
                    if (verSum != 15 || gorSum != 15) continue@outer
                }
                sum++
            }
        }
        return sum
    }
}