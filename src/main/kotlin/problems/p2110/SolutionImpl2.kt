package problems.p2110

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.11 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/solutions/7412703/kotlin-on-18ms-o1-by-alexeyminkin-03iv)
 */
class SolutionImpl2 : Solution {
    override fun getDescentPeriods(prices: IntArray): Long {
        var result = 1L
        var smoothCount = 1
        for (i in 1 until prices.size) {
            if (prices[i] != prices[i - 1] - 1) smoothCount = 0
            result += ++smoothCount
        }
        return result
    }
}