package problems.p3637

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.07 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/trionic-array-i/solutions/7547862/kotlin-on-1ms-o1-universal-by-alexeymink-bzrr)
 */
class SolutionImpl1 : Solution {
    override fun isTrionic(nums: IntArray): Boolean {
        val n = nums.size
        var i = 1
        var monotone = 1
        for (m in 0 until 3) {
            if (!(i < n && (nums[i - 1] - nums[i]) * monotone < 0)) return false
            while (i < n && (nums[i - 1] - nums[i]) * monotone < 0) i++
            monotone *= -1
        }
        return i == n
    }
}