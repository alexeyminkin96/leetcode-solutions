package problems.p3652

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `77.04 MB` (Beats `87.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/solutions/7421363/kotlin-on-4ms-o1-exactly-one-pass-by-ale-jd8f)
 */
class SolutionImpl1 : Solution {
    override fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        var arraySum = 0L
        var windowProfit = 0L
        val halfK = k / 2
        for (i in 0 until k) {
            arraySum += prices[i] * strategy[i]
            if (i >= halfK)
                windowProfit += prices[i]
        }

        windowProfit -= arraySum
        var maxProfit = 0L

        for (i in k until prices.size) {
            arraySum += prices[i] * strategy[i]
            if (windowProfit > maxProfit) maxProfit = windowProfit
            windowProfit += prices[i] - prices[i - halfK] - (prices[i] * strategy[i] - prices[i - k] * strategy[i - k])
        }
        if (windowProfit > maxProfit) maxProfit = windowProfit
        return arraySum + maxProfit
    }
}