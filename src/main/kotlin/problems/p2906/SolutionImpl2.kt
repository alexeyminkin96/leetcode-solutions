package problems.p2906

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `103.74 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(n * m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/construct-product-matrix/solutions/7687034/kotlin-onm-8ms-onm-by-alexeyminkin-jk2e)
 */
class SolutionImpl2 : Solution {
    override fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val mod = 12345
        val n = grid.size
        val m = grid[0].size
        val prefProd = IntArray(n * m + 1); prefProd[0] = 1
        val sufProd = IntArray(n * m + 1); sufProd[n * m] = 1
        var pi = 1
        var si = n * m - 1
        for (i in 0 until n) {
            for (j in 0 until m) {
                prefProd[pi] = ((prefProd[pi++ - 1].toLong() * grid[i][j]) % mod).toInt()
                sufProd[si] = ((sufProd[si-- + 1].toLong() * grid[n - 1 - i][m - 1 - j]) % mod).toInt()
            }
        }
        return Array(n) { i -> IntArray(m) { j -> (prefProd[i * m + j] * sufProd[i * m + j + 1]) % mod } }
    }
}