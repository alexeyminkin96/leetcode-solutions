package problems.p1665

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `105.38 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/solutions/8198819/kotlin-onlogn-14ms-on-primitives-only-by-fb9n)
 */
class SolutionImpl3 : Solution {
    override fun minimumEffort(tasks: Array<IntArray>): Int {
        val bits = 14
        val mask = (1 shl bits) - 1
        val ar = IntArray(tasks.size) { (tasks[it][1] - tasks[it][0]) shl bits or tasks[it][0] }
        Arrays.sort(ar)
        var res = 0
        for (i in 0 until tasks.size)
            res = Math.max(res + (ar[i] and mask), (ar[i] shr bits) + (ar[i] and mask))
        return res
    }
}