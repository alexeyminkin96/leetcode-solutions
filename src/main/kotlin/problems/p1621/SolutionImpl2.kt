package problems.p1621

/**
 * **LeetCode Performance**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `52.14 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(1)` per query, `O(n*k)` precomputation
 * - Space: `O(1)` per query, `O(n*k)` precomputation
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/solutions/8524202/kotlin-onk-0ms-onk-by-alexeyminkin-1yy3)
 */
class SolutionImpl2 : Solution {
    override fun numberOfSets(n: Int, k: Int): Int {
        return dp[n - k - 1][(k shl 1) + 1]
    }
}

private val dp = run {
    val dp = Array(1000) { IntArray(2002) }
    dp[0] = IntArray(2002) { 1 }
    for (l in 1 until dp.size)
        for (i in 1 until dp[l].size)
            dp[l][i] = (dp[l - 1][i] + dp[l][i - 1]) % 1_000_000_007
    dp
}