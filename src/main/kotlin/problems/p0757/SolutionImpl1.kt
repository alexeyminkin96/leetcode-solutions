package problems.p0757

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `16 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.85 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Sort intervals by end
 * - Keep two last points (l, r)
 * - If interval has 0 points → add two
 * - If interval has 1 point → add one
 * - Else skip
 *
 * **Techniques:**
 * - Greedy
 * - Sort
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/set-intersection-size-at-least-two/solutions/7362629/kotlin-on-log-n-16ms-o1-by-alexeyminkin-jelo)
 */
class SolutionImpl1 : Solution {
    override fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { a, b -> a[1] - b[1] }

        var count = 0
        var l = -1
        var r = -1

        for (i in 0 until intervals.size) {
            val start = intervals[i][0]
            val end = intervals[i][1]
            if (r < start) {
                count += 2
                l = end - 1
                r = end
            } else if (l < start) {
                count++
                l = r
                r = end
                if (l == r) l--
            }
        }
        return count
    }
}