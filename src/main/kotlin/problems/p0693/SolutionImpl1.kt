package problems.p0693

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.90 MB` (Beats `81.25%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/binary-number-with-alternating-bits/solutions/7588946/kotlin-o1-0ms-o1-using-highest-one-bit-b-5xfs)
 */
class SolutionImpl1 : Solution {
    override fun hasAlternatingBits(n: Int): Boolean {
        return n + (n ushr 1) == (n.takeHighestOneBit() shl 1) - 1
    }
}
