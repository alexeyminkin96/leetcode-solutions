package problems.p1510

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.70 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n√n)` preprocessing, `O(1)` per call
 * - Space: `O(n)` preprocessing, `O(1)` per call
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game-iv/solutions/8452123/kotlin-onsqrtn-0ms-on-by-alexeyminkin-2u5r)
 */
class SolutionImpl2 : Solution {
    override fun winnerSquareGame(n: Int): Boolean {
        return dp[N - n]
    }
}

private val N = 100_000
private val dp = run {
    val dp = BooleanArray(N + 1)
    for (i in N - 1 downTo 0) {
        var x = 1
        while (i + x * x <= N) {
            if (!dp[i + x * x]) {
                dp[i] = true
                break
            }
            x++
        }
    }
    dp
}