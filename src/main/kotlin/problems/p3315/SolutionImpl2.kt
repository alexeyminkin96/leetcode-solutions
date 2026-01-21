package problems.p3315

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.75 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/solutions/7512089/kotlin-on-1ms-o1-by-alexeyminkin-cn2f)
 */
class SolutionImpl2 : Solution {
    override fun minBitwiseArray(nums: List<Int>): IntArray {
        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            val zeroStartAt = nums[i].inv().takeLowestOneBit()
            result[i] = if (zeroStartAt == 1) -1 else nums[i] - zeroStartAt.ushr(1)
        }
        return result
    }
}