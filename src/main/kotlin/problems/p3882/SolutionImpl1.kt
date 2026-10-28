package problems.p3882

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `49 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `72.58 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * max(grid))`
 * - Space: `O(n * max(grid))`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-xor-path-in-a-grid/solutions/8592377/kotlin-omnmaxgrid-53ms-onmaxgrid-by-alex-kll0)
 */
class SolutionImpl1 : Solution {
    override fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var max = 1
        for (i in 0 until m)
            for (j in 0 until n)
                if (grid[i][j] > max) max = grid[i][j]
        max = max.takeHighestOneBit() shl 1
        val dp = Array(n + 1) { BooleanArray(max) }
        dp[1][0] = true
        var nextDp = BooleanArray(max)
        for (i in 0 until m)
            for (j in 0 until n) {
                val cell = grid[i][j]
                val leftDp = dp[j]
                val upDp = dp[j + 1]
                for (k in 0 until max)
                    if (leftDp[k] || upDp[k]) nextDp[cell xor k] = true
                dp[j + 1] = nextDp
                nextDp = upDp
                Arrays.fill(nextDp, false)
            }
        for (k in 0 until max)
            if (dp[n][k]) return k
        return -1
    }
}