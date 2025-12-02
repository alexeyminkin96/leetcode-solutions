package problems.p0069

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `97.35%` of Kotlin submissions)
 * - Memory: `40.95 MB` (Beats `72.57%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log x)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sqrtx/solutions/7388092/kotlin-ologn-1ms-o1-by-alexeyminkin-bq1w)
 */
class SolutionImpl1 : Solution {
    override fun mySqrt(x: Int): Int {
        var l = 0L
        var r = x.toLong()
        while (l < r) {
            val m = (l + r + 1) / 2
            if (m * m > x)
                r = m - 1
            else
                l = m
        }
        return l.toInt()
    }
}