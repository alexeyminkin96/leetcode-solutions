package problems.p1784

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.50 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solutions/7628847/kotlin-on-0ms-o1-by-alexeyminkin-boek)
 */
class SolutionImpl1 : Solution {
    override fun checkOnesSegment(s: String): Boolean {
        val n = s.length
        var i = 0
        while (i < n && s[i] == '1') i++
        while (i < n && s[i] == '0') i++
        return i == n
    }
}