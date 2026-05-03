package problems.p0796

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.84 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotate-string/solutions/8132875/kotlin-on2-0ms-o1-by-alexeyminkin-p7i9)
 */
class SolutionImpl1 : Solution {
    override fun rotateString(s: String, goal: String): Boolean {
        val n = s.length
        if (n != goal.length) return false
        outer@ for (i in 0 until n) {
            for (j in 0 until n)
                if (s[j] != goal[(i + j) % n]) continue@outer
            return true
        }
        return false
    }
}