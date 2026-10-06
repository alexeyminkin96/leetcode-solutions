package problems.p0678

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.99 MB` (Beats `98.17%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/valid-parenthesis-string/solutions/8558551/kotlin-on-0ms-o1-by-alexeyminkin-kb8q)
 */
class SolutionImpl1 : Solution {
    override fun checkValidString(s: String): Boolean {
        var min = 0
        var max = 0
        for (c in s) {
            min = if (c == '(') min + 1 else Math.max(min - 1, 0)
            max = if (c == ')') max - 1 else max + 1
            if (max < 0) return false
        }
        return (min == 0)
    }
}