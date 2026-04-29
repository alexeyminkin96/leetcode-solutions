package problems.p3252

/**
 * **LeetCode Performance:**
 * - Runtime: `1115 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `64.22 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^4)`
 * - Space: `O(n^2)`
 */
class SolutionImpl1 : Solution {
    override fun maximumScore(grid: Array<IntArray>): Long {
        val n = grid.size
        val ps = Array(n) { LongArray(n + 1) }
        for (i in 0 until n)
            for (j in 0 until n)
                ps[j][i + 1] = ps[j][i] + grid[i][j]
        val none = Long.MIN_VALUE shr 2
        var dp = Array(n + 1) { LongArray(n + 1) { none } }
        var ndp = Array(n + 1) { LongArray(n + 1) { none } }
        for (p in 0..n)
            dp[p][0] = 0
        for (j in 0 until n) {
            for (i in 0..n) {
                for (p in 0..n) {
                    var sum = none
                    for (pp in 0..n) {
                        val add = Math.max(ps[j][Math.max(pp, i)] - ps[j][p], 0)
                        sum = Math.max(sum, dp[p][pp] + add)
                    }
                    ndp[i][p] = sum
                }
            }
            val buf = dp
            dp = ndp
            ndp = buf
        }
        var res = 0L
        for (p in 0..n)
            res = Math.max(res, dp[0][p])
        return res
    }
}