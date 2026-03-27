package problems.p2946

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.59 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/solutions/7701703/kotlin-omn-1ms-o1-by-alexeyminkin-ayxp)
 */
class SolutionImpl1 : Solution {
    override fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        val n = mat[0].size
        if (k % n == 0) return true
        for (i in 0 until mat.size)
            for (j in 0 until n)
                if (mat[i][j] != mat[i][(j + k) % n]) return false
        return true
    }
}