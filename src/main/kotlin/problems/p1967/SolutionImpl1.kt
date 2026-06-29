package problems.p1967

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.76 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m * k)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/solutions/8365200/kotlin-onmk-7ms-o1-by-alexeyminkin-7ek6)
 */
class SolutionImpl1 : Solution {
    override fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.count { word.contains(it) }
    }
}