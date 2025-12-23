package problems.p2054

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `66 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `125.24 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/two-best-non-overlapping-events/solutions/7432633/kotlin-onlogn-66ms-on-2-sort-start-end-b-r0h1)
 */
class SolutionImpl1 : Solution {
    private val comparatorEnd = compareBy<IntArray> { it[1] }
    private val comparatorStart = compareBy<IntArray> { it[0] }
    override fun maxTwoEvents(events: Array<IntArray>): Int {
        Arrays.sort(events, comparatorEnd)
        val lValues = IntArray(events.size + 1)
        val lTimes = IntArray(events.size + 1)
        for (i in 0 until events.size) {
            lValues[i + 1] = Math.max(events[i][2], lValues[i])
            lTimes[i + 1] = events[i][1]
        }

        Arrays.sort(events, comparatorStart)
        val rValues = IntArray(events.size + 1)
        val rTimes = IntArray(events.size + 1)
        rTimes[events.size] = 1_000_000_001
        for (i in events.size - 1 downTo 0) {
            rValues[i] = Math.max(events[i][2], rValues[i + 1])
            rTimes[i] = events[i][0]
        }

        var result = 0
        var l = 0
        var r = 0
        while (l < lTimes.size && r < rTimes.size) {
            if (lTimes[l] < rTimes[r])
                result = Math.max(result, lValues[l++] + rValues[r])
            else
                r++
        }

        return result
    }
}