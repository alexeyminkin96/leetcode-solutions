package problems.p0085

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.74 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m)`
 * - Space: `O(n*m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximal-rectangle/solutions/7485723/kotlin-onm-6ms-onm-primitives-only-by-al-96an)
 */
class SolutionImpl1 : Solution {
    override fun maximalRectangle(matrix: Array<CharArray>): Int {
        var maxSquare = 0
        val n = matrix.size
        val m = matrix[0].size
        val heights = Array(n + 1) { IntArray(m + 2) }
        val indexes = IntArray(m + 2)
        for (i in 1 until n + 1) {
            val row = heights[i]
            var last = 0
            for (j in 1 until m + 2) {
                if (j < m + 1)
                    row[j] = (heights[i - 1][j] + 1) * (matrix[i - 1][j - 1] - '0')
                while (row[indexes[last]] > row[j])
                    maxSquare = Math.max(maxSquare, row[indexes[last]] * (j - indexes[--last] - 1))
                indexes[++last] = j
            }
        }
        return maxSquare
    }
}
