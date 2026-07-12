package problems.p1331

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `20 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `66.42 MB` (Beats `68.75%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rank-transform-of-an-array/solutions/8392704/kotlin-onlogn-20ms-on-primitives-only-by-609j)
 */
class SolutionImpl1 : Solution {
    override fun arrayRankTransform(arr: IntArray): IntArray {
        val sort = LongArray(arr.size) { (arr[it].toLong() shl 32) or it.toLong() }
        Arrays.sort(sort)
        val res = IntArray(arr.size)
        var prev = Int.MIN_VALUE
        var cur = 0
        for (num in sort) {
            res[num.toInt()] = if ((num shr 32) > prev) ++cur else cur
            prev = (num shr 32).toInt()
        }
        return res
    }
}