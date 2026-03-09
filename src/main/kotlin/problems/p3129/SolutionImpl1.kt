package problems.p3129

/**
 * **LeetCode Performance:**
 * - Runtime: `330 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `250.03 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(z * o * l)`
 * - Space: `O(z * o * l)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/solutions/7636594/kotlin-ozol-330ms-ozol-by-alexeyminkin-ayat)
 */
class SolutionImpl1 : Solution {
    override fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val mod = 1_000_000_007L
        val dp = Array(zero + 1) { Array(one + 1) { Array(2) { LongArray(limit + 1) } } }
        dp[1][0][0][1] = 1
        dp[0][1][1][1] = 1
        for (z in 0..zero)
            for (o in 0..one)
                for (b in 0..1)
                    for (l in 1..limit) {
                        var cur = dp[z][o][b][l]
                        if (cur == 0L) continue
                        if (cur >= mod) cur %= mod
                        if (z + 1 - b <= zero && o + b <= one && l + 1 <= limit)
                            dp[z + 1 - b][o + b][b][l + 1] += cur
                        if (z + b <= zero && o + 1 - b <= one)
                            dp[z + b][o + 1 - b][1 - b][1] += cur
                    }

        var result = 0L
        for (n in 0..1)
            for (l in 1..limit)
                result += dp[zero][one][n][l]
        return (result % mod).toInt()
    }
}