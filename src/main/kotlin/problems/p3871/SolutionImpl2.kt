package problems.p3871

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.08 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-commas-in-range-ii/solutions/8511447/kotlin-ologn-0ms-o1-by-alexeyminkin-myoc)
 */
class SolutionImpl2 : Solution {
    override fun countCommas(n: Long): Long {
        var rank = 1000L
        var res = 0L
        while (n >= rank) {
            res += n - rank + 1
            rank *= 1000
        }
        return res
    }
}