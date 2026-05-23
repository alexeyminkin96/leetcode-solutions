package problems.p1752

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.73 MB` (Beats `84.62%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/8287636/kotlin-on-0ms-o1-by-alexeyminkin-xxwh)
 */
class SolutionImpl1 : Solution {
    override fun check(nums: IntArray): Boolean {
        var i = 1
        while (i < nums.size && nums[i] >= nums[i - 1]) i++
        if (i++ == nums.size) return true
        while (i < nums.size && nums[i] >= nums[i - 1]) i++
        return (i == nums.size) && (nums[0] >= nums[i - 1])
    }
}