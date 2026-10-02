package problems.p0022

/**
 * **LeetCode Performance**
 * - Runtime: `1 ms` (Beats `97.79%` of Kotlin submissions)
 * - Memory: `42.43 MB` (Beats `88.94%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(4^n/sqrt(n))`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/generate-parentheses/solutions/8551615/kotlin-o4nsqrtn-1ms-on-primitives-only-b-tvf8)
 */
class SolutionImpl8 {
    fun generateParenthesis(n: Int): Array<String> {
        var count = 1
        for (i in 0 until n)
            count = count * (2 * (2 * i + 1)) / (i + 2)
        val charsBuf = CharArray(n shl 1)
        val res = arrayOfNulls<String>(count)
        var resI = 0
        fun dfs(l: Int, r: Int, bits: Int) {
            var bits = bits
            if (l == n && r == n) {
                for (i in charsBuf.size - 1 downTo 0) {
                    charsBuf[i] = if (bits and 1 == 0) '(' else ')'
                    bits = bits ushr 1
                }
                res[resI++] = String(charsBuf)
                return
            }
            if (l < n) dfs(l + 1, r, bits shl 1)
            if (r < l) dfs(l, r + 1, (bits shl 1) or 1)
        }
        dfs(0, 0, 0)
        return res as Array<String>
    }
}