package problems.p3418

/**
 * **LeetCode Performance:**
 * - Runtime: `22 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `98.38 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/solutions/7748946/kotlin-omn-2ms-on-by-alexeyminkin-clt7)
 */
class SolutionImpl3 : Solution {
    override fun maximumAmount(coins: Array<IntArray>): Int {
        val nul = -1_000_000_000
        val neutrals = 2
        val n = coins[0].size
        val d = Array(neutrals + 2) { IntArray(n + 1) { nul } }
        for (k in 1..neutrals + 1) d[k][1] = 0
        for (i in 0 until coins.size)
            for (j in 0 until n)
                for (k in neutrals + 1 downTo 1)
                    d[k][j + 1] = maxOf(d[k - 1][j + 1], d[k - 1][j], d[k][j + 1] + coins[i][j], d[k][j] + coins[i][j])
        return d[neutrals + 1][n]
    }
}
