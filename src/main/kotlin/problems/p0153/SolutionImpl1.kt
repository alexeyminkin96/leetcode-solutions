package problems.p0153

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.41 MB` (Beats `98.28%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/8235842/kotlin-ologn-0ms-o1-by-alexeyminkin-d584)
 */
class SolutionImpl1 : Solution {
    override fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (nums[l] > nums[r]) {
            val mid = (l + r) shr 1
            if (nums[mid] < nums[l]) r = mid else l = mid + 1
        }
        return nums[l]
    }
}