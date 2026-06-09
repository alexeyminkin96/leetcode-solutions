package problems.p3689

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `98.79%` of Kotlin submissions)
 * - Memory: `61.99 MB` (Beats `98.79%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-total-subarray-value-i/solutions/8366317/kotlin-on-3ms-o1-by-alexeyminkin-eztk)
 */
class SolutionImpl1 : Solution {
    override fun maxTotalValue(nums: IntArray, k: Int): Long {
        var min = nums[0]
        var max = nums[0]
        for (num in nums) {
            if (num < min) min = num
            if (num > max) max = num
        }
        return k.toLong() * (max - min)
    }
}