package problems.p0137

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `68.85%` of Kotlin submissions)
 * - Memory: `46.77 MB` (Beats `39.34%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (b in 0 until 32) {
            var bitCount = 0
            for (i in 0 until nums.size) {
                bitCount += (nums[i] ushr b) and 1
            }
            result = result or (bitCount % 3 shl b)
        }
        return result
    }
}