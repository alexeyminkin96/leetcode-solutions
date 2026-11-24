package problems.p3411

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.31 MB` (Beats `60.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-subarray-with-equal-products/solutions/8623351/kotlin-on-2ms-o1-by-alexeyminkin-5wyk)
 */
class SolutionImpl1 : Solution {
    override fun maxLength(nums: IntArray): Int {
        var res = 2
        var windowMask = 0
        var l = 0
        for (r in 0 until nums.size) {
            val numMask = masks[nums[r]]
            while (windowMask and numMask != 0)
                windowMask = windowMask xor masks[nums[l++]]
            windowMask = windowMask or numMask
            res = Math.max(res, r - l + 1)
        }
        return res
    }
}

private val masks = intArrayOf(0, 0, 1, 2, 1, 4, 3, 8, 1, 2, 5)