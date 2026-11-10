package problems.p3693

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `171.07 MB` (Beats `22.22%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/climbing-stairs-ii/solutions/8607676/kotlin-on-7ms-o1-by-alexeyminkin-66mh)
 */
class SolutionImpl1 : Solution {
    override fun climbStairs(n: Int, costs: IntArray): Int {
        var dp1 = 0
        var dp2 = 0
        var dp3 = 0
        for (i in 0 until n) {
            val dp4 = costs[i] + minOf(dp1 + 9, dp2 + 4, dp3 + 1)
            dp1 = dp2
            dp2 = dp3
            dp3 = dp4
        }
        return dp3
    }
}