package problems.p3314

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.70 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
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
