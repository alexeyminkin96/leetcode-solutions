package problems.p2463

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `19 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.86 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n^2)`
 * - Space: `O(m * n)`
 */
class SolutionImpl1 : Solution {
    override fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val m = factory.size
        val n = robot.size
        val robot = IntArray(n) { robot[it] }
        Arrays.sort(robot)
        Arrays.sort(factory, compareBy { it[0] })
        val dp = Array(m + 1) { LongArray(n + 1) { Long.MAX_VALUE } }
        dp[0][0] = 0

        for (i in 0 until m) {
            val fact = factory[i]
            val pos = fact[0]
            val limit = fact[1]
            for (j in 0..n) {
                var sum = dp[i][j]
                if (sum == Long.MAX_VALUE) break
                dp[i + 1][j] = Math.min(dp[i + 1][j], sum)
                for (k in j until Math.min(n, j + limit)) {
                    sum += Math.abs(robot[k] - pos)
                    dp[i + 1][k + 1] = Math.min(dp[i + 1][k + 1], sum)
                }
            }
        }
        return dp[m][n]
    }
}