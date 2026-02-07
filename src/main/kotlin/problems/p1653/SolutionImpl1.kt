package problems.p1653

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.24 MB` (Beats `85.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-removals-to-balance-array/solutions/7557279/kotlin-onlogn-31ms-o1-by-alexeyminkin-kh2w)
 */
class SolutionImpl1 : Solution {
    override fun minimumDeletions(s: String): Int {
        var lastA = 0
        var lastB = 0
        for (c in s.toByteArray()) {
            lastB = minOf(lastB - c + 98, lastA)
            lastA += c - 97
        }
        return lastB
    }
}
