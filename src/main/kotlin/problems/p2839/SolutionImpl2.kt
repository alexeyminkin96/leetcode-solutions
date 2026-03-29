package problems.p2839

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.66 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - Any important remarks about this solution
 */
class SolutionImpl2 : Solution {
    override fun canBeEqual(s1: String, s2: String): Boolean {
        return minOf(s1[0], s1[2]) == minOf(s2[0], s2[2])
            && maxOf(s1[0], s1[2]) == maxOf(s2[0], s2[2])
            && minOf(s1[1], s1[3]) == minOf(s2[1], s2[3])
            && maxOf(s1[1], s1[3]) == maxOf(s2[1], s2[3])
    }

    private fun minOf(a: Char, b: Char): Char = if (a < b) a else b
    private fun maxOf(a: Char, b: Char): Char = if (a > b) a else b
}