package problems.p2657

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.56 MB` (Beats `87.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/solutions/8282090/kotlin-on-2ms-o1-by-alexeyminkin-7drw)
 */
class SolutionImpl2 : Solution {
    override fun findThePrefixCommonArray(a: IntArray, b: IntArray): IntArray {
        var bits = 0L
        var count = 0
        for (i in 0 until a.size) {
            val aBit = 1L shl a[i]
            if (bits and aBit != 0L) count++ else bits = bits or aBit
            val bBit = 1L shl b[i]
            if (bits and bBit != 0L) count++ else bits = bits or bBit
            a[i] = count
        }
        return a
    }
}