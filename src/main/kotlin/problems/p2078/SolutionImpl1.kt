package problems.p2078

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.34 MB` (Beats `81.25%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/two-furthest-houses-with-different-colors/solutions/8010010/kotlin-on-0ms-o1-by-alexeyminkin-zztf)
 */
class SolutionImpl1 : Solution {
    override fun maxDistance(colors: IntArray): Int {
        var i = 0
        while (colors[0] == colors[colors.size - 1 - i] && colors[colors.size - 1] == colors[i]) i++
        return colors.size - 1 - i
    }
}