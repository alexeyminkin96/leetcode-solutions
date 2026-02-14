package problems.p0799

/**
 * **LeetCode Performance:**
 * - Runtime: `91 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(query_row^2)`
 * - Space: `O(query_row)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/champagne-tower/solutions/7579337/kotlin-orow2-91ms-orow-by-alexeyminkin-oacv)
 */
class SolutionImpl2 : Solution {
    override fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val row = DoubleArray(100)
        row[0] = poured.toDouble()
        for (i in 0 until query_row) {
            for (j in i downTo 0) {
                row[j] = Math.max(row[j] - 1, 0.toDouble())
                row[j + 1] += row[j] / 2
                row[j] /= 2.toDouble()
            }
        }
        return Math.min(row[query_glass], 1.toDouble())
    }
}