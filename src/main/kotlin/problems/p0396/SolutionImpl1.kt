package problems.p0396

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.07 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotate-function/solutions/8125690/kotlin-on-4ms-o1-by-alexeyminkin-wslv)
 */
class SolutionImpl1 : Solution {
    override fun maxRotateFunction(nums: IntArray): Int {
        val n = nums.size
        var f = 0
        var sum = 0
        for (i in 0 until n) {
            sum += nums[i]
            f += nums[i] * i
        }
        var res = f
        for (i in n - 1 downTo 0) {
            f += sum - nums[i] * n
            res = Math.max(res, f)
        }
        return res
    }
}