package problems.p0856

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.17 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/score-of-parentheses/solutions/8558582/kotlin-on-0ms-o1-by-alexeyminkin-ubvt)
 */
class SolutionImpl1 : Solution {
    override fun scoreOfParentheses(s: String): Int {
        var res = 0
        var h = 0
        var prev = ')'
        for (c in s) {
            if (c == '(') h++
            else if (prev == '(') res += 1 shl --h else h--
            prev = c
        }
        return res
    }
}