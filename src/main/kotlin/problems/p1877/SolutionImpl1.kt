package problems.p1877

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `540 ms` (Beats `90.00%` of Kotlin submissions)
 * - Memory: `60.92 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minPairSum(nums: IntArray): Int {
        Arrays.sort(nums)
        var max = 0
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[l++] + nums[r--]
            if (sum > max) max = sum
        }
        return max
    }
}