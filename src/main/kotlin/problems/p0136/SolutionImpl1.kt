package problems.p0136

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.84 MB` (Beats `82.21%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/single-number/solutions/7419890/kotlin-on-1ms-o1-by-alexeyminkin-wvvx)
 */
class SolutionImpl1 : Solution {
    override fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size) {
            result = result xor nums[i]
        }
        return result
    }
}