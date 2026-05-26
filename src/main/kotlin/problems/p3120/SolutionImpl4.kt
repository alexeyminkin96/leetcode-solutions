package problems.p3120

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.72 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-the-number-of-special-characters-i/solutions/8294464/kotlin-on-1ms-o1-by-alexeyminkin-tla3)
 */
class SolutionImpl4 : Solution {
    override fun numberOfSpecialChars(word: String): Int {
        var counts = 0L
        for (c in word)
            counts = counts or (1L shl (c - if (c < 'a') 'A' else 'G'))
        return (counts and (counts shr 26)).countOneBits()
    }
}