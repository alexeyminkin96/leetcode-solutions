package problems.p1872

/**
 * **LeetCode Performance:**
 * - Runtime: `378 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.81 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game-viii/solutions/8479835/kotlin-on-378ms-o1-by-alexeyminkin-uljt)
 */
class SolutionImpl2 : Solution {
    override fun stoneGameVIII(stones: IntArray): Int {
        var dp = 0
        for (i in 0 until stones.size) {
            dp += stones[i]
            stones[i] = dp
        }
        for (i in stones.size - 2 downTo 1)
            dp = Math.max(dp, stones[i] - dp)
        return dp
    }
}