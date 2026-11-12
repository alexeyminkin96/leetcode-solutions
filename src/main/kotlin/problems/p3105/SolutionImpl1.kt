package problems.p3105

/**
 * **LeetCode Performance**
 * - Runtime: `2 ms` (Beats `85.71%` of Kotlin submissions)
 * - Memory: `46.67 MB` (Beats `14.29%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/solutions/8610232/kotlin-on-2ms-o1-by-alexeyminkin-t5hm)
 */
class SolutionImpl1 : Solution {
    override fun longestMonotonicSubarray(nums: IntArray): Int {
        var res = 1
        var cur = 1
        var dir = 1
        for (i in 1 until nums.size) {
            val diff = (nums[i] - nums[i - 1]) * dir
            if (diff == 0)
                cur = 1
            else if (diff > 0)
                cur++
            else {
                cur = 2
                dir *= -1
            }
            res = Math.max(res, cur)
        }
        return res
    }
}