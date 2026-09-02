package problems.p3875

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.93 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/construct-uniform-parity-array-i/solutions/8499901/kotlin-o1-1ms-o1-by-alexeyminkin-mmpj)
 */
class SolutionImpl1 : Solution {
    override fun uniformArray(nums1: IntArray): Boolean {
        // If all nums are even - nums is already valid
        // Else take any odd num and subtract it from each even num, which will make them odd
        return true
    }
}