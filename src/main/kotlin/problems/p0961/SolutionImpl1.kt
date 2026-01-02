package problems.p0961

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `80.00%` of Kotlin submissions)
 * - Memory: `50.66 MB` (Beats `13.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun repeatedNTimes(nums: IntArray): Int {
        val map = IntArray(10_001)
        var i = 0
        while (++map[nums[i]] == 1) i++
        return nums[i]
    }
}