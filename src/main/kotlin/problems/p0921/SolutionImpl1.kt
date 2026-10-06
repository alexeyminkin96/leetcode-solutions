package problems.p0921

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/solutions/8558514/kotlin-on-0ms-o1-by-alexeyminkin-q7cz)
 */
class SolutionImpl1 : Solution {
    override fun minAddToMakeValid(s: String): Int {
        var res = 0
        var count = 0
        for (c in s) {
            if (c == '(') count++
            else if (count > 0) count--
            else res++
        }
        return res + count
    }
}