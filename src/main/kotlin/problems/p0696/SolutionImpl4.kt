package problems.p0696

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.87 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-binary-substrings/solutions/7591236/kotlin-on-7ms-o1-by-alexeyminkin-pr5c)
 */
class SolutionImpl4 : Solution {
    override fun countBinarySubstrings(s: String): Int {
        val s = s.toCharArray()
        var lStart = 0
        var rStart = 0
        var result = 0
        var i = 1
        while (i < s.size) {
            while (i < s.size && s[i] == s[rStart]) i++
            result += Math.min(i - rStart, rStart - lStart)
            lStart = rStart
            rStart = i
        }
        return result
    }
}