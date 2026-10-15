package problems.p2913

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `85.71%` of Kotlin submissions)
 * - Memory: `44.64 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/solutions/8573341/kotlin-on2-7ms-oc-by-alexeyminkin-yz8f)
 */
class SolutionImpl1 : Solution {
    override fun sumCounts(nums: List<Int>): Int {
        var res = 0
        val present = BooleanArray(101)
        for (l in 0 until nums.size) {
            var distinct = 0
            Arrays.fill(present, false)
            for (r in l until nums.size) {
                if (!present[nums[r]]) distinct++
                present[nums[r]] = true
                res += distinct * distinct
            }
        }
        return res
    }
}