package problems.p3314

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.64 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/solutions/7509123/kotlin-on-2ms-o1-by-alexeyminkin-inez)
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
