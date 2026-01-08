package problems.p0058

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.70 MB` (Beats `97.20%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/length-of-last-word/solutions/7478867/kotlin-on-0ms-o1-by-alexeyminkin-n1a0)
 */
class SolutionImpl1 : Solution {
    override fun lengthOfLastWord(s: String): Int {
        var length = 0
        var i = s.length - 1
        while (i >= 0 && s[i] == ' ') i--
        while (i >= 0 && s[i--] != ' ') length++
        return length
    }
}