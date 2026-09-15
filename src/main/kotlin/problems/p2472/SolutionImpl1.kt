package problems.p2472

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.51 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * k)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/solutions/8522749/kotlin-onk-1ms-o1-by-alexeyminkin-6pdz)
 */
class SolutionImpl1 : Solution {
    override fun maxPalindromes(s: String, k: Int): Int {
        val n = s.length
        val s = s.toCharArray()
        var res = 0
        var i = 0
        fun palindrome(lStart: Int, rStart: Int): Boolean {
            var l = lStart
            var r = rStart
            while (l < r)
                if (s[l++] != s[r--]) return false
            res++
            i = rStart + 1
            return true
        }
        while (i + k < n)
            if (!(palindrome(i, i + k - 1) || palindrome(i, i + k))) i++
        if (i + k == n)
            palindrome(i, i + k - 1)
        return res
    }
}