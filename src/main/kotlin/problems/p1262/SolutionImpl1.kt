package problems.p1262

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.15 MB` (Beats `25.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/greatest-sum-divisible-by-three/solutions/7370192/kotlin-on-4ms-o1-by-alexeyminkin-yx5u)
 */
class SolutionImpl1 : Solution {
    override fun maxSumDivThree(nums: IntArray): Int {
        val mins = Array(2) { IntArray(2) { 10_001 } }
        var sum = 0
        for (i in 0 until nums.size) {
            sum += nums[i]
            val rem = nums[i] % 3
            if (rem != 0) {
                var candidate = nums[i]
                for (j in 0 until 2) {
                    if (candidate < mins[rem - 1][j]) {
                        val buf = mins[rem - 1][j]
                        mins[rem - 1][j] = candidate
                        candidate = buf
                    }
                }
            }
        }

        val rem = sum % 3
        if (rem == 0)
            return sum
        val sub = minOf(mins[rem - 1][0], mins[rem % 2][0] + mins[rem % 2][1])
        if (sub == 10_001)
            return 0
        return sum - sub
    }
}
