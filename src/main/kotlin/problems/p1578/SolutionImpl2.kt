package problems.p1578

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.98 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Traverse once.
 * - For consecutive same-color balloons, add min of the two times.
 * - Keep max time of current block.
 * - Reset when color changes.
 *
 * **Techniques:**
 * - Greedy
 * - Single-pass comparison
 */
class SolutionImpl2 : Solution {
    override fun minCost(colors: String, neededTime: IntArray): Int {
        var removeTime = 0

        var previousColorMaxTime = neededTime[0]

        for (i in 1 until colors.length) {
            if (colors[i] == colors[i - 1])
                if (neededTime[i] > previousColorMaxTime) {
                    removeTime += previousColorMaxTime
                    previousColorMaxTime = neededTime[i]
                } else
                    removeTime += neededTime[i]
            else
                previousColorMaxTime = neededTime[i]
        }
        return removeTime
    }
}