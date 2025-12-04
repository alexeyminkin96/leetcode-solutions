package problems.p2211

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-collisions-on-a-road/solutions/7391659/kotlin-on-13ms-o1-by-alexeyminkin-idqa)
 */
class SolutionImpl1 : Solution {
    override fun countCollisions(directions: String): Int {
        var result = 0
        var hasStopFromLeft = false
        var rCount = 0
        for (c in directions.toCharArray()) {
            if (c == 'R') {
                rCount++
                hasStopFromLeft = true
            } else {
                result += rCount
                rCount = 0
                if (c == 'L' && hasStopFromLeft)
                    result++
                if (c == 'S')
                    hasStopFromLeft = true
            }
        }
        return result
    }
}