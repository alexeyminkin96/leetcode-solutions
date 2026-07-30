package problems.p3014

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.54 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/solutions/8428138/kotlin-onc2-13ms-o1-by-alexeyminkin-51m4)
 */
class SolutionImpl3 : Solution {
    override fun minimumPushes(word: String): Int {
        val div = word.length shr 3                                 // n/8
        val arith = (div + 1) * div shr 1                           // (div+1)*div/2 - arithmetic progression sum
        return (arith shl 3) + (word.length and 7) * (div + 1)      // (arith*8) + (n%8) * (div+1)
    }
}