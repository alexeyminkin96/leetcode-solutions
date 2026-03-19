package problems.p3212

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `172.37 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/solutions/7663953/kotlin-omn-o21ms-omn-2d-prefix-sum-bitma-6glh)
 */
class SolutionImpl1 : Solution {
    override fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val bits = 20
        val yVal = 1L shl bits
        val mask = (yVal) - 1
        val ps = Array(grid.size + 1) { LongArray(grid[0].size + 1) }
        var count = 0
        for (i in 1 until ps.size) {
            for (j in 1 until ps[0].size) {
                val char = grid[i - 1][j - 1]
                val cell = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] +
                    if (char == 'X') 1L else if (char == 'Y') yVal else 0L
                if (cell != 0L && cell and mask == cell ushr bits) count++
                ps[i][j] = cell
            }
        }
        return count
    }
}
