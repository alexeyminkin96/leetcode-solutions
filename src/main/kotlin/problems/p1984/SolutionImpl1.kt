package problems.p1984

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.12 MB` (Beats `96.77%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/solutions/7522716/kotlin-onlogn-6ms-o1-by-alexeyminkin-hqft)
 */
class SolutionImpl1 : Solution {
    override fun minimumDifference(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)
        var minDiff = 100_000
        for (i in k - 1 until nums.size) {
            minDiff = Math.min(nums[i] - nums[i - (k - 1)], minDiff)
        }
        return minDiff
    }
}