package problems.p3090

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.81 MB` (Beats `60.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/solutions/8460298/kotlin-on-1ms-o1-by-alexeyminkin-8qsw)
 */
class SolutionImpl1 : Solution {
    override fun maximumLengthSubstring(s: String): Int {
        val counts = IntArray(26)
        var l = 0
        var r = 0
        var hasMore = false
        var res = 0
        while (r < s.length) {
            hasMore = if (!hasMore) ++counts[s[r++] - 'a'] == 3 else counts[s[l++] - 'a']-- != 3
            if (!hasMore) res = Math.max(res, r - l)
        }
        return res
    }
}