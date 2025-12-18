package problems.p0137

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `93.44%` of Kotlin submissions)
 * - Memory: `45.66 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy/solutions/7421363/kotlin-on-4ms-o1-exactly-one-pass-by-ale-jd8f)
 */
class SolutionImpl3 : Solution {
    override fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for (i in 0 until nums.size) {
            twos = twos or (ones and nums[i])
            ones = ones xor nums[i]
            val threes = ones and twos
            ones -= threes
            twos -= threes
        }
        return ones
    }
}