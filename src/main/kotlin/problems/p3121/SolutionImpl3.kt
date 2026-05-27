package problems.p3121

/**
 * **LeetCode Performance:**
 * - Runtime: `232 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.06 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-the-number-of-special-characters-ii/solutions/8297179/kotlin-on-232ms-o1-1-variable-by-alexeym-ptus)
 */
class SolutionImpl3 : Solution {
    override fun numberOfSpecialChars(word: String): Int {
        var counts = 0L
        for (c in word)
            counts = if (c < 'a') counts or (1L shl (c - 'A'))
            else (counts or (1L shl (c - 'G'))) and ((counts and (1L shl (c - 'a'))) shl 26).inv()
        return (counts and (counts shr 26)).countOneBits()
    }
}