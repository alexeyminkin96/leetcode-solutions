package problems.p1018

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.28 MB` (Beats `41.67%` of Kotlin submissions)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/binary-prefix-divisible-by-5/solutions/7371324/kotlin-on-1ms-o1-by-alexeyminkin-pc3k)
 */
class SolutionImpl1 : Solution {
    override fun prefixesDivBy5(nums: IntArray): BooleanArray {
        var num = 0
        val result = BooleanArray(nums.size)
        for (i in 0 until nums.size) {
            num = (num shl 1 or nums[i]) % 5
            result[i] = num == 0
        }
        return result
    }
}
