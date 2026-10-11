package problems.p2778

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.38 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(√n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-of-squares-of-special-elements/solutions/8566745/kotlin-osqrtn-1ms-o1-by-alexeyminkin-dk8z)
 */
class SolutionImpl1 : Solution {
    override fun sumOfSquares(nums: IntArray): Int {
        val n = nums.size
        var res = 0
        for (i in 1..Math.sqrt(n.toDouble()).toInt()) {
            val j = n / i
            if (i * j != n) continue
            res += nums[i - 1] * nums[i - 1]
            if (j != i)
                res += nums[j - 1] * nums[j - 1]
        }
        return res
    }
}