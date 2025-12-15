package problems.p2110

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.07 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun getDescentPeriods(prices: IntArray): Long {
        var result = 0L
        var smoothCount = 1L
        for (i in 1 until prices.size) {
            if (prices[i] != prices[i - 1] - 1) {
                result += smoothCount * (smoothCount + 1) / 2
                smoothCount = 0
            }
            smoothCount++
        }
        result += smoothCount * (smoothCount + 1) / 2
        return result
    }
}