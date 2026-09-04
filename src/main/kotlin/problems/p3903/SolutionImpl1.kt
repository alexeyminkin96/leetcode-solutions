package problems.p3903

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.76 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-stable-index-i/solutions/8501055/kotlin-on-1ms-on-by-alexeyminkin-yiv8)
 */
class SolutionImpl1 : Solution {
    override fun firstStableIndex(nums: IntArray, k: Int): Int {
        val mins = IntArray(nums.size)
        var min = Int.MAX_VALUE
        for (i in nums.size - 1 downTo 0) {
            min = Math.min(min, nums[i])
            mins[i] = min
        }
        var max = -1
        for (i in 0 until nums.size) {
            max = Math.max(max, nums[i])
            if (max - mins[i] <= k) return i
        }
        return -1
    }
}