package problems.p1190

/**
 * **LeetCode Performance**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/solutions/8543337/kotlin-on-0ms-on-primitives-only-by-alex-g2nq)
 */
class SolutionImpl2 : Solution {
    override fun reverseParentheses(s: String): String {
        val mark = 'z' + 1
        val n = s.length
        val s = s.toCharArray()
        val brStack = IntArray(n shr 1)
        var brStackI = 0
        var charCount = 0
        for (i in 0 until n)
            when (s[i]) {
                '(' -> brStack[brStackI++] = i
                ')' -> {
                    s[i] = mark + brStack[--brStackI]
                    s[brStack[brStackI]] = mark + i
                }

                else -> charCount++
            }
        var sI = 0
        val res = CharArray(charCount)
        var resI = 0
        var move = 1
        while (resI < charCount)
            when {
                s[sI] >= mark -> {
                    move *= -1
                    sI = s[sI] - mark + move
                }

                else -> {
                    res[resI++] = s[sI]
                    sI += move
                }
            }
        return String(res)
    }
}