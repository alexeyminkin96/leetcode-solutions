package problems.p0020

/**
 * **LeetCode Performance**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.62 MB` (Beats `99.13%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/valid-parentheses/solutions/8550362/kotlin-on-1ms-on-by-alexeyminkin-7ghj)
 */
class SolutionImpl2 : Solution {
    override fun isValid(s: String): Boolean {
        val ar = CharArray(s.length)
        var i = 0
        for (char in s) {
            val leftBracket = when (char) {
                ')' -> '('
                ']' -> '['
                '}' -> '{'
                else -> ' '
            }
            if (leftBracket == ' ')
                ar[i++] = char
            else if (--i < 0 || leftBracket != ar[i])
                return false
        }
        return i == 0
    }
}
