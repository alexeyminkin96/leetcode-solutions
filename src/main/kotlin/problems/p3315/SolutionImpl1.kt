package problems.p3315

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.65 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minBitwiseArray(nums: List<Int>): IntArray {
        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            val zeroStartAt = nums[i].inv().countTrailingZeroBits()
            result[i] = if (zeroStartAt == 0) -1 else nums[i] - 1.shl(zeroStartAt - 1)
        }
        return result
    }
}