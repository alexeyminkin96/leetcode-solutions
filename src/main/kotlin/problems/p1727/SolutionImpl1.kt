package problems.p1727

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `16 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `91.53 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * log n)`
 * - Space: `O(log n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/largest-submatrix-with-rearrangements/solutions/7653485/kotlin-omnlogn-16ms-o1-by-alexeyminkin-fkp4)
 */
class SolutionImpl1 : Solution {
    override fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        for (i in 1 until m)
            for (j in 0 until n)
                matrix[i][j] *= matrix[i - 1][j] + 1
        var area = 0
        for (i in 0 until m) {
            Arrays.sort(matrix[i])
            for (j in n - 1 downTo 0)
                area = Math.max(area, matrix[i][j] * (n - j))
        }
        return area
    }
}
