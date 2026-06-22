package problems.p1189

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.59 MB` (Beats `91.30%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-balloons/solutions/8351137/kotlin-on-3ms-o1-by-alexeyminkin-b5fp)
 */
class SolutionImpl2 : Solution {
    override fun maxNumberOfBalloons(text: String): Int {
        val counts = IntArray(26)
        for (c in text.toCharArray()) counts[c - 'a']++
        return minOf(counts[1], counts[0], counts[11] shr 1, counts[14] shr 1, counts[13])
    }
}