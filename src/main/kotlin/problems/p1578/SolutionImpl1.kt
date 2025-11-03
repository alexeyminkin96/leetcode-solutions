package problems.p1578

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.12 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Keep running sum of current color block times.
 * - Track max time within the block.
 * - When color changes, subtract the max time from the accumulated sum.
 * - At the end, subtract the last block’s max time.
 *
 * **Techniques:**
 * - Linear scan
 * - Greedy block aggregation
 */
class SolutionImpl1 : Solution {
    override fun minCost(colors: String, neededTime: IntArray): Int {
        var removeTime = neededTime[0]

        var previousColorMaxTime = neededTime[0]
        var previousColor = colors[0]

        for (i in 1 until colors.length) {
            if (colors[i] != previousColor) {
                removeTime -= previousColorMaxTime
                previousColor = colors[i]
                previousColorMaxTime = neededTime[i]
            } else if (neededTime[i] > previousColorMaxTime)
                previousColorMaxTime = neededTime[i]
            removeTime += neededTime[i]
        }
        removeTime -= previousColorMaxTime
        return removeTime
    }
}