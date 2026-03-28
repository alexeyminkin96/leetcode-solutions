package problems.p2573

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `154.65 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-string-with-lcp/solutions/7708130/kotlin-on2-12ms-on-by-alexeyminkin-cw56)
 */
class SolutionImpl1 : Solution {
    override fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size
        val word = CharArray(n) { 'a' }
        for (i in 0 until n) {
            if (lcp[i][i] != n - i) return ""
            for (j in i + 1 until n) {
                if (lcp[i][j] != lcp[j][i] || lcp[i][j] > n - j) return ""
                if (lcp[i][j] == 0 && word[j] == word[i] && ++word[j] > 'z') return ""
            }
        }
        for (i in n - 2 downTo 0)
            for (j in n - 1 downTo i + 1)
                if (lcp[i][j] != if (word[i] == word[j]) 1 + (if (j < n - 1) lcp[i + 1][j + 1] else 0) else 0) return ""
        return String(word)
    }
}
