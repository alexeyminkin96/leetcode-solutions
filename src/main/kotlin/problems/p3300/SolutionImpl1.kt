package problems.p3300

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.24 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/solutions/8300597/kotlin-on-1ms-o1-by-alexeyminkin-e3wy)
 */
class SolutionImpl1 : Solution {
    override fun minElement(nums: IntArray): Int {
        var res = 36
        outer@ for (i in 0 until nums.size) {
            var num = nums[i]
            var sum = 0
            while (num > 0) {
                sum += num % 10
                if (sum >= res) continue@outer
                num /= 10
            }
            if (sum == 1) return 1
            res = sum
        }
        return res
    }
}