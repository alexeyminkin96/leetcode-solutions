package problems.p3946

/**
 * **LeetCode Performance:**
 * - Runtime: `22 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `53.36 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(C * log C + n * budget)`
 * - Space: `O(C + budget)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-items-from-sale-i/solutions/8626568/kotlin-onbclogc-22ms-obc-by-alexeyminkin-dqo9)
 */
class SolutionImpl2 : Solution {
    override fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size
        val factorCounts = IntArray(1501)
        for (item in items) factorCounts[item[0]]++
        val factorToBonus = IntArray(1501) { -1 }
        for (item in items) {
            val factor = item[0]
            if (factorToBonus[factor] != -1) continue
            for (j in factor..1500 step factor)
                factorToBonus[factor] += factorCounts[j]
        }
        var min = Int.MAX_VALUE
        for (item in items) min = Math.min(min, item[1])
        val dp = IntArray(budget + 1) { it / min }
        for (i in 0 until n) {
            if (factorToBonus[items[i][0]] == 0) continue
            val weight = factorToBonus[items[i][0]] + 1
            val price = items[i][1]
            for (j in budget downTo price)
                dp[j] = Math.max(dp[j], dp[j - price] + weight)
        }
        return dp[budget]
    }
}