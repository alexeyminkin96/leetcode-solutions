package problems.p0137

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `55.74%` of Kotlin submissions)
 * - Memory: `45.97 MB` (Beats `88.52%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun singleNumber(nums: IntArray): Int {
        val bitCount = IntArray(32)
        for (i in 0 until nums.size) {
            for (b in 0 until bitCount.size) {
                bitCount[b] += (nums[i] ushr b) and 1
            }
        }
        var result = 0
        for (b in 0 until bitCount.size) {
            result = result or (bitCount[b] % 3 shl b)
        }
        return result
    }
}