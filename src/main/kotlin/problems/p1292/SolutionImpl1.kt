package problems.p1292

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `60.61 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m*log(min(n,m)))`
 * - Space: `O(n*m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/solutions/7506821/kotlin-onmlogminnm-9ms-onm-by-alexeymink-x5n1)
 */
class SolutionImpl1 : Solution {
    override fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val n = mat.size
        val m = mat[0].size
        val ps = Array(n + 1) { IntArray(m + 1) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j] + mat[i][j]
            }
        }
        var l = 0
        var r = minOf(n, m) + 1
        out@ while (l + 1 < r) {
            val side = (r + l) / 2
            for (i in 0..n - side) {
                for (j in 0..m - side) {
                    if (ps[i + side][j + side] - ps[i][j + side] - ps[i + side][j] + ps[i][j] <= threshold) {
                        l = side
                        continue@out
                    }
                }
            }
            r = side
        }
        return l
    }
}