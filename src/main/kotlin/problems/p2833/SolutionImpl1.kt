package problems.p2833

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.20 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/furthest-point-from-origin/solutions/8088108/kotlin-on-1ms-o1-by-alexeyminkin-fv8m)
 */
class SolutionImpl1 : Solution {
    override fun furthestDistanceFromOrigin(moves: String): Int {
        var dist = 0
        var gaps = 0
        for (c in moves.toCharArray()) {
            when (c) {
                'R' -> dist++
                'L' -> dist--
                '_' -> gaps++
            }
        }
        return Math.abs(dist) + gaps
    }
}