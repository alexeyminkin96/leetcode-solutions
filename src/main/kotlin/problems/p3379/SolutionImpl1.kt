package problems.p3379

/**
 * **LeetCode Performance:**
 * - Runtime: `143 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.86 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/transformed-array/solutions/7553920/kotlin-on-143ms-o1-by-alexeyminkin-lm8k)
 */
class SolutionImpl1 : Solution {
    override fun constructTransformedArray(nums: IntArray): IntArray {
        val n = nums.size
        return IntArray(n) { i -> nums[((i + nums[i]).rem(n) + n).rem(n)] }
    }
}