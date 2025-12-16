package problems.p0125

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.04 MB` (Beats `78.23%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/solutions/7412703/kotlin-on-18ms-o1-by-alexeyminkin-03iv)
 */
class SolutionImpl1 : Solution {
    override fun isPalindrome(s: String): Boolean {
        val ca = s.toCharArray()
        var l = -1
        var r = ca.size
        while (++l < --r) {
            var lc = ca[l].code
            var rc = ca[r].code
            while (l < r && !(lc in 48..57 || lc in 65..90 || lc in 97..122)) {
                lc = ca[++l].code
            }
            while (l < r && !(rc in 48..57 || rc in 65..90 || rc in 97..122)) {
                rc = ca[--r].code
            }
            if (l == r) return true
            if (!(lc == rc || lc == rc + 32 && rc >= 65 || lc + 32 == rc && lc >= 65)) return false
        }
        return true
    }
}
