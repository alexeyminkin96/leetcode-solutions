package problems.p2124

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.48 MB` (Beats `20.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/solutions/8621302/kotlin-on-0ms-o1-by-alexeyminkin-ujsn)
 */
class SolutionImpl1 : Solution {
    override fun checkString(s: String): Boolean {
        val n = s.length
        var i = 0
        while (i < n && s[i] == 'a') i++
        while (i < n && s[i] == 'b') i++
        return i == n
    }
}