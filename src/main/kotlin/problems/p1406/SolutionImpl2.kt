package problems.p1406

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.98 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game-iii/solutions/8438448/kotlin-on-6ms-o1-by-alexeyminkin-n1q5)
 */
class SolutionImpl2 : Solution {
    override fun stoneGameIII(sv: IntArray): String {
        val n = sv.size
        var sv0 = sv[n - 1]
        var sv1 = 0
        var sv2 = 0
        var dp0 = sv[n - 1]
        var dp1 = 0
        var dp2 = 0
        if (n > 1) {
            sv1 = sv0
            sv0 = sv[n - 2]
            dp1 = dp0
            dp0 = Math.max(sv0 - dp1, sv0 + sv1)
        }
        for (i in n - 3 downTo 0) {
            sv2 = sv1
            sv1 = sv0
            sv0 = sv[i]
            val next = Math.max(sv0 - dp0, Math.max(sv0 + sv1 - dp1, sv0 + sv1 + sv2 - dp2))
            dp2 = dp1
            dp1 = dp0
            dp0 = next
        }
        return if (dp0 > 0) "Alice" else if (dp0 < 0) "Bob" else "Tie"
    }
}