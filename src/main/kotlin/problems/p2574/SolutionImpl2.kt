package problems.p2574

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `97.81%` of Kotlin submissions)
 * - Memory: `46.53 MB` (Beats `94.26%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/left-and-right-sum-differences/solutions/8366224/kotlin-on-2ms-o1-in-place-by-alexeyminki-1izg)
 */
class SolutionImpl2 : Solution {
    override fun leftRightDifference(nums: IntArray): IntArray {
        var s = 0
        for (i in 0 until nums.size)
            s += nums[i]
        var l = 0
        for (i in 0 until nums.size) {
            val num = nums[i]
            nums[i] = Math.abs(s - (l shl 1) - num)
            l += num
        }
        return nums
    }
}