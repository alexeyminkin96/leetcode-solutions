package problems.p1288

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.07 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/remove-covered-intervals/solutions/8379462/kotlin-onlogn-3ms-on-by-alexeyminkin-5ymp)
 */
class SolutionImpl2 : Solution {
    override fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val sort = LongArray(intervals.size)
        { (intervals[it][0].toLong() shl 32) or (Int.MAX_VALUE - intervals[it][1].toLong()) }
        Arrays.sort(sort)
        var r = 0
        var res = 0
        for (s in sort) {
            val nextR = Int.MAX_VALUE - s.toInt()
            if (nextR > r) {
                r = nextR
                res++
            }
        }
        return res
    }
}