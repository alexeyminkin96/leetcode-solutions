package problems.p1291

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.53 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sequential-digits/solutions/8394206/kotlin-o1-0ms-o1-primitives-only-precalc-by5x)
 */
class SolutionImpl1 : Solution {
    override fun sequentialDigits(low: Int, high: Int): IntArray {
        fun biSearch(num: Int): Int {
            val i = Arrays.binarySearch(list, num)
            return if (i < 0) -i - 1 else i
        }
        return Arrays.copyOfRange(list, biSearch(low), biSearch(high + 1))
    }
}

private val list = intArrayOf(
    12, 23, 34, 45, 56, 67, 78, 89,
    123, 234, 345, 456, 567, 678, 789,
    1234, 2345, 3456, 4567, 5678, 6789,
    12345, 23456, 34567, 45678, 56789,
    123456, 234567, 345678, 456789,
    1234567, 2345678, 3456789,
    12345678, 23456789,
    123456789
)