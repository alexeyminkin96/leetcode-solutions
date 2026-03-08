package problems.p1980

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-unique-binary-string/solutions/7633968/kotlin-on-0ms-o1-one-line-by-alexeyminki-jldq)
 */
class SolutionImpl1 : Solution {
    override fun findDifferentBinaryString(nums: Array<String>): String {
        return String(CharArray(nums.size) { 'a' - nums[it][it].code })
    }
}
