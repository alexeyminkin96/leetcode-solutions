package problems.p3789

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.75 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-cost-to-acquire-required-items/solutions/8608953/kotlin-o1-1ms-o1-by-alexeyminkin-rqiv)
 */
class SolutionImpl1 : Solution {
    override fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
        val bothCount = if (cost1 + cost2 >= costBoth) Math.min(need1, need2).toLong() else 0L
        val sumBoth = bothCount * costBoth
        val sum1 = (need1 - bothCount) * Math.min(costBoth, cost1)
        val sum2 = (need2 - bothCount) * Math.min(costBoth, cost2)
        return sumBoth + sum1 + sum2
    }
}