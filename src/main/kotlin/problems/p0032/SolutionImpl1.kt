package problems.p0032

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.79 MB` (Beats `84.44%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-valid-parentheses/solutions/8553182/kotlin-on-1ms-o1-by-alexeyminkin-hvek)
 */
class SolutionImpl1 : Solution {
    override fun longestValidParentheses(s: String): Int {
        val s = s.toCharArray()
        var max = 0
        var l = 0
        var count = 0
        for (r in 0 until s.size) {
            count += 1 - ((s[r] - '(') shl 1)
            while (count < 0) count -= 1 - ((s[l++] - '(') shl 1)
            if (count == 0) max = Math.max(max, r - l + 1)
        }
        if (count > 0) {
            var r = s.size - 1
            count = 0
            for (l in s.size - 1 downTo l) {
                count += 1 - ((s[l] - '(') shl 1)
                while (count > 0) count -= 1 - ((s[r--] - '(') shl 1)
                if (count == 0) max = Math.max(max, r - l + 1)
            }
        }
        return max
    }
}
