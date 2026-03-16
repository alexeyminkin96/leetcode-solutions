package problems.p1878

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.98 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * min(m, n))`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/solutions/7651726/kotlin-omnminmn-14ms-omn-diagonals-prefi-7n33)
 */
class SolutionImpl1 : Solution {
    override fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size

        val md = Array(m) { grid[it].copyOf() }
        for (i in m - 2 downTo 0)
            for (j in 1 until n)
                md[i][j] += md[i + 1][j - 1]

        val rd = Array(m) { grid[it].copyOf() }
        for (i in 1 until m)
            for (j in 1 until n)
                rd[i][j] += rd[i - 1][j - 1]

        val result = IntArray(3)

        for (i in 0 until m) {
            for (j in 0 until n) {
                fillValue(grid[i][j], result)
                for (k in 1 until minOf((m - i + 1) ushr 1, j + 1, n - j)) {
                    val lt = md[i][j] - md[i + k][j - k]
                    val rb = md[i + k][j + k] - md[i + (k shl 1)][j]
                    val lb = rd[i + (k shl 1)][j] - rd[i + k][j - k]
                    val rt = rd[i + k][j + k] - rd[i][j]
                    val sum = lt + rb + lb + rt + grid[i + k][j - k] - grid[i + k][j + k]
                    fillValue(sum, result)
                }
            }
        }
        return when {
            result[2] != 0 -> result
            result[1] != 0 -> result.copyOf(2)
            else -> result.copyOf(1)
        }
    }

    private fun fillValue(value: Int, ar: IntArray) {
        var value = value
        for (r in 0 until ar.size) {
            if (value == ar[r]) break
            if (value > ar[r]) {
                val buf = ar[r]
                ar[r] = value
                value = buf
            }
        }
    }
}