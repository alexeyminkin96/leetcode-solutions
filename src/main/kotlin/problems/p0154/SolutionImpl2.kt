package problems.p0154

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.62 MB` (Beats `97.77%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/8235842/kotlin-ologn-0ms-o1-by-alexeyminkin-d584)
 */
class SolutionImpl2 : Solution {
    override fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r && nums[l] >= nums[r]) {
            val mid = (l + r) shr 1
            val midNum = nums[mid]
            when {
                midNum < nums[l] || midNum < nums[r] -> r = mid
                midNum > nums[l] || midNum > nums[r] -> l = mid + 1
                else -> {
                    l++
                    r--
                }
            }
        }
        return nums[l]
    }
}