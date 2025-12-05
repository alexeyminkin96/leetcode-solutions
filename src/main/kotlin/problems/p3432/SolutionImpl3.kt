package problems.p3432

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.54 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-partitions-with-even-sum-difference/solutions/7393261/kotlin-on-1ms-o1-by-alexeyminkin-43nk)
 */
class SolutionImpl3 : Solution {
    override fun countPartitions(nums: IntArray): Int {
        var lastBit = 0
        for (i in 0 until nums.size) {
            lastBit = nums[i] and 1 xor lastBit
        }
        return (lastBit xor 1) * (nums.size - 1)
    }
}