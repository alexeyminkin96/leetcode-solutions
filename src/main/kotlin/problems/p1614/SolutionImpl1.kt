package problems.p1614

/**
 * **LeetCode Performance**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.48 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/solutions/8544427/kotlin-on-0ms-o1-by-alexeyminkin-5u5e)
 */
class SolutionImpl1 : Solution {
    override fun maxDepth(s: String): Int {
        var maxCount = 0
        var curCount = 0
        for (c in s)
            if (c == '(') maxCount = Math.max(maxCount, ++curCount)
            else if (c == ')') curCount--
        return maxCount
    }
}
