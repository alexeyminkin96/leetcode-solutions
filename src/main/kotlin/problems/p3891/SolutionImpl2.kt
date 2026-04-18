package problems.p3891

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `77.85 MB` (Beats `54.29%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/solutions/7984252/korlin-on-7ms-o1-by-alexeyminkin-nci7)
 */
class SolutionImpl2 : Solution {
    override fun minIncrease(nums: IntArray): Long {
        var odd = 0L
        var even = 0L
        var prev: Int
        var cur = nums[0]
        var next = nums[1]
        for (i in 1 until nums.size - 1) {
            prev = cur
            cur = next
            next = nums[i + 1]
            val peak = Math.max(Math.max(prev, next) - cur + 1, 0)
            if (i and 1 == 1) odd += peak
            else even = Math.min(even + peak, odd)
        }
        return if (nums.size and 1 == 1) odd else even
    }
}