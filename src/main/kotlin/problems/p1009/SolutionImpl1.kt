package problems.p1009

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.14 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/complement-of-base-10-integer/solutions/7640766/kotlin-o1-0ms-o1-by-alexeyminkin-2gky)
 */
class SolutionImpl1 : Solution {
    override fun bitwiseComplement(n: Int): Int {
        var ones = n or 1
        ones = ones or (ones shr 1)
        ones = ones or (ones shr 2)
        ones = ones or (ones shr 4)
        ones = ones or (ones shr 8)
        ones = ones or (ones shr 16)
        return ones xor n
    }
}