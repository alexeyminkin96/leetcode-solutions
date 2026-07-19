package problems.p1081

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/solutions/8408082/kotlin-on-1ms-o1-primitives-only-by-alex-822i)
 */
class SolutionImpl1 : Solution {
    override fun smallestSubsequence(s: String): String {
        val s = s.toCharArray()
        val counts = IntArray(26)
        var resSize = 0
        for (c in s) if (counts[c - 'a']++ == 0) resSize++
        val persist = BooleanArray(26)
        val res = CharArray(resSize + 1)
        res[0] = 'a' - 1
        var resIdx = 1
        for (c in s) {
            counts[c - 'a']--
            if (persist[c - 'a']) continue
            while (res[resIdx - 1] > c && counts[res[resIdx - 1] - 'a'] > 0) persist[res[--resIdx] - 'a'] = false
            res[resIdx++] = c
            persist[c - 'a'] = true
        }
        return String(res, 1, resSize)
    }
}