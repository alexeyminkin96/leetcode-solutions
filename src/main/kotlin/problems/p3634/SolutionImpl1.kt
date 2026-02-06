package problems.p3634

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `31 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `82.35 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-removals-to-balance-array/solutions/7557279/kotlin-onlogn-31ms-o1-by-alexeyminkin-kh2w)
 */
class SolutionImpl1 : Solution {
    override fun minRemoval(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)
        val k = k.toLong()
        var l = 0
        var r = 0
        var size = 0
        while (r < nums.size) {
            while (r < nums.size && k * nums[l] >= nums[r]) r++
            size = Math.max(size, r - l++)
        }
        return nums.size - size
    }
}