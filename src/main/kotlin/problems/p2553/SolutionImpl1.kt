package problems.p2553

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.73 MB` (Beats `96.63%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*d)`
 * - Space: `O(n*d)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/separate-the-digits-in-an-array/solutions/8187364/kotlin-on-1ms-o1-primitives-only-by-alex-m93d)
 */
class SolutionImpl1 : Solution {
    override fun separateDigits(nums: IntArray): IntArray {
        var count = 0
        for (i in 0 until nums.size) {
            var num = nums[i]
            while (num != 0) {
                count++
                num /= 10
            }
        }
        val res = IntArray(count)
        for (i in nums.size - 1 downTo 0) {
            var num = nums[i]
            while (num != 0) {
                val div = num / 10
                res[--count] = num - div * 10
                num = div
            }
        }
        return res
    }
}