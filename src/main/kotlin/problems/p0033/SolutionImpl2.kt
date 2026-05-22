package problems.p0033

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.85 MB` (Beats `84.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/8285807/kotlin-ologn-o1-by-alexeyminkin-ci1g)
 */
class SolutionImpl2 : Solution {
    override fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r) shr 1
    //(target in [nums[l]; nums[mid]] or [nums[mid]; nums[l]])    (left part is sorted)
            if (((nums[l] <= target) == (target <= nums[mid])) == (nums[l] <= nums[mid])) r = mid else l = mid + 1
        }
        return if (nums[l] == target) l else -1
    }
}