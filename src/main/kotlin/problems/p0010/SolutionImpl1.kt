package problems.p0010

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `99.08%` of Kotlin submissions)
 * - Memory: `42.76 MB` (Beats `86.24%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)
 * - Space: `O(n * m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/regular-expression-matching/solutions/7489074/kotlin-onm-2ms-onm-by-alexeyminkin-lv7n)
 */
class SolutionImpl1 : Solution {
    override fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, p, 0, 0, Array(s.length + 1) { BooleanArray(p.length + 1) })
    }

    private fun isMatch(s: String, p: String, sI: Int, pI: Int, visited: Array<BooleanArray>): Boolean {
        var sI = sI
        var pI = pI
        while (pI < p.length) {
            if (visited[sI][pI]) return false
            visited[sI][pI] = true
            if (pI == p.length - 1 || p[pI + 1] != '*') {
                if (sI >= s.length || p[pI] != '.' && p[pI] != s[sI]) return false
                pI++
                sI++
                continue
            }
            sI--
            do {
                if (isMatch(s, p, ++sI, pI + 2, visited)) return true
            } while (sI < s.length && (s[sI] == p[pI] || p[pI] == '.'))
            return false
        }
        return sI == s.length
    }
}