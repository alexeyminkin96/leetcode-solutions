package problems.p1784

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.39 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun checkOnesSegment(s: String): Boolean {
        val n = s.length
        for (i in 2 until n)
            if (s[i] - s[i - 1] == 1) return false
        return true
    }
}