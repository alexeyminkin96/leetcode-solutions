package problems.p0115

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.28 MB` (Beats `83.78%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`, m=s.length, n=t.length
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/distinct-subsequences/solutions/8505250/kotlin-omn-6ms-om-by-alexeyminkin-pj03)
 */
class SolutionImpl2 : Solution {
    override fun numDistinct(s: String, t: String): Int {
        val n = s.length
        val s = s.toCharArray()
        val ps = IntArray(n + 1) { 1 }
        for (tChar in t.toCharArray()) {
            var prev = ps[0]
            ps[0] = 0
            for (iS in 0 until n) {
                val nextPrev = ps[iS + 1]
                ps[iS + 1] = ps[iS] + if (s[iS] == tChar) prev else 0
                prev = nextPrev
            }
        }
        return ps[n]
    }
}