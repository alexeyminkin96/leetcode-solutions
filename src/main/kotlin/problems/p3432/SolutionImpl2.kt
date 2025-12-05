package problems.p3432

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.16 MB` (Beats `88.24%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun countPartitions(nums: IntArray): Int {
        var result = 0
        val lastIndex = nums.size - 1
        for (i in 1..lastIndex) {
            nums[i] += nums[i - 1]
        }
        for (i in 0 until lastIndex) {
            result += nums[i].shl(1).minus(nums[lastIndex]).and(1).xor(1)
        }
        return result
    }
}
