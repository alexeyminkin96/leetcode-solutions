package problems.p1582

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.85 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m + n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/special-positions-in-a-binary-matrix/solutions/7624349/kotlin-omn-2ms-omn-by-alexeyminkin-rlq0)
 */
class SolutionImpl2 : Solution {
    override fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rows = IntArray(m)
        val cols = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    rows[i] = if (rows[i] == 0) j + 1 else -1
                    cols[j]++
                }
            }
        }
        var count = 0
        for (i in 0 until m)
            if (rows[i] > 0 && cols[rows[i] - 1] == 1) count++
        return count
    }
}