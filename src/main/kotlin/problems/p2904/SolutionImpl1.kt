package problems.p2904

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.58 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * k)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/solutions/8484975/kotlin-onk-1ms-o1-by-alexeyminkin-pum4)
 */
class SolutionImpl1 : Solution {
    override fun shortestBeautifulSubstring(s: String, k: Int): String {
        val n = s.length
        var l = 0
        var r = 0
        var count = 0
        while (r < n && count < k)
            count += s[r++] - '0'
        if (count < k) return ""
        while (s[l] == '0') l++
        var minLenL = l
        var minLenR = r
        fun isLess(diff: Int): Boolean {
            for (i in minLenL until minLenR)
                if (s[i + diff] < s[i]) return true
                else if (s[i + diff] > s[i]) return false
            return false
        }
        while (r < n) {
            while (r < n && s[r] == '0') r++
            if (r == n) break
            r++
            while (s[++l] == '0');
            if (r - l < minLenR - minLenL || r - l == minLenR - minLenL && isLess(l - minLenL)) {
                minLenR = r
                minLenL = l
            }
        }
        return s.substring(minLenL, minLenR)
    }
}