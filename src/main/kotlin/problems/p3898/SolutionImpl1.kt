package problems.p3898

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `67.42 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-degree-of-each-vertex/solutions/7892258/kotlin-on2-2ms-on-by-alexeyminkin-cwa6)
 */
class SolutionImpl1 : Solution {
    override fun findDegrees(matrix: Array<IntArray>): IntArray {
        val n = matrix.size
        val res = IntArray(n)
        for (i in 0 until n - 1){
            for (j in i + 1 until n){
                val cell = matrix[i][j]
                res[i] += cell
                res[j] += cell
            }
        }
        return res
    }
}