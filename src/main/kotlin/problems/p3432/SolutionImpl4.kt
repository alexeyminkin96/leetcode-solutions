package problems.p3432

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.41 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl4 : Solution {
    override fun countPartitions(nums: IntArray): Int {
        return nums.fold(0) { lastBit, n -> n and 1 xor lastBit }.xor(1).times(nums.size - 1)
    }
}