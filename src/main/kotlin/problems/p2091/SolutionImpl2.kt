package problems.p2091

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.35 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/solutions/8491654/kotlin-on-2ms-o1-by-alexeyminkin-p9se)
 */
class SolutionImpl2 : Solution {
    override fun minimumDeletions(nums: IntArray): Int {
        val n = nums.size
        var iMin = 0
        var min = nums[iMin]
        var iMax = 0
        var max = nums[iMax]
        for (i in 1 until n) {
            val num = nums[i]
            if (num < min) {
                iMin = i
                min = num
            } else if (nums[i] > max) {
                iMax = i
                max = num
            }
        }
        val l = Math.min(iMin, iMax)
        val r = Math.max(iMin, iMax)
        return n - maxOf(l, r - 1 - l, n - 1 - r)
    }
}