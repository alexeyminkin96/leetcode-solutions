package problems.p1021

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.44 MB` (Beats `91.49%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/remove-outermost-parentheses/solutions/8562119/kotlin-on-2ms-on-by-alexeyminkin-hdgl)
 */
class SolutionImpl1 : Solution {
    override fun removeOuterParentheses(s: String): String {
        val res = s.toCharArray()
        var resI = 0
        var count = 0
        for (c in res) {
            count -= ((c - '(') shl 1) - 1
            if (count == 0 || count == 1 && c == '(') continue
            res[resI++] = c
        }
        return String(res, 0, resI)
    }
}