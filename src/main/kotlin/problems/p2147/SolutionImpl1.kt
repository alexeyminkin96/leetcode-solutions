package problems.p2147

/**
 * **LeetCode Performance:**
 * - Runtime: `18 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.21 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/solutions/7412703/kotlin-on-18ms-o1-by-alexeyminkin-03iv)
 */
class SolutionImpl1 : Solution {
    override fun numberOfWays(corridor: String): Int {
        val mod = 1_000_000_007
        var sCount = 0
        var pCount = 0
        var ways = 1L
        for (c in corridor.toCharArray()) {
            if (c == 'S') {
                if (sCount < 2)
                    sCount++
                else {
                    ways *= pCount + 1
                    if (ways >= mod) ways %= mod
                    sCount = 1
                    pCount = 0
                }
            } else if (sCount == 2) pCount++
        }
        return if (sCount == 2) ways.toInt() else 0
    }
}