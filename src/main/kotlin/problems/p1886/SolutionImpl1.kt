package problems.p1886

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.68 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/solutions/7679653/kotlin-on2-o0ms-o1-by-alexeyminkin-7z4s)
 */
class SolutionImpl1 : Solution {
    override fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        var is0 = true
        var is90 = true
        var is180 = true
        var is270 = true
        for (i in 0 until n)
            for (j in 0 until n) {
                is0 = is0 && (target[i][j] == mat[i][j])
                is90 = is90 && (target[i][j] == mat[j][n - i - 1])
                is180 = is180 && (target[i][j] == mat[n - i - 1][n - j - 1])
                is270 = is270 && (target[i][j] == mat[n - j - 1][i])
                if (!(is0 || is90 || is180 || is270)) return false
            }
        return true
    }
}