package problems.p3010

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.49 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/solutions/7541730/kotlin-on-1ms-o1-by-alexeyminkin-i3nz)
 */
class SolutionImpl1 : Solution {
    override fun minimumCost(nums: IntArray): Int {
        var l = 51
        var r = 51
        for (i in 1 until nums.size) {
            when {
                nums[i] < l -> {
                    r = l
                    l = nums[i]
                }

                nums[i] < r -> r = nums[i]
            }
        }
        return nums[0] + l + r
    }
}
