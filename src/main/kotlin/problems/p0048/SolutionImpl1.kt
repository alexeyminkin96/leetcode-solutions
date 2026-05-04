package problems.p0048

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.66 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotate-image/solutions/8136918/kotlin-on2-0ms-o1-by-alexeyminkin-n25e)
 */
class SolutionImpl1 : Solution {
    override fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in 0 until n.shr(1))
            for (j in i until n - 1 - i) {
                val top = matrix[i][j]                              //top
                matrix[i][j] = matrix[n - 1 - j][i]                 //left -> top
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j] //button -> left
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i] //right -> button
                matrix[j][n - 1 - i] = top                          //top -> right
            }
    }
}