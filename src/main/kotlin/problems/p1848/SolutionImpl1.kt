package problems.p1848

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.73 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-distance-to-the-target-element/solutions/7890656/kotlin-on-0ms-o1-early-return-by-alexeym-4zpa)
 */
class SolutionImpl1 : Solution {
    override fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var i = 0
        while (!(start - i >= 0 && nums[start - i] == target || start + i < nums.size && nums[start + i] == target)) i++
        return i
    }
}