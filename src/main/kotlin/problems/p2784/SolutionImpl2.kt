package problems.p2784

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.66 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-array-is-good/solutions/8231272/kotlin-on-1ms-o1-in-place-by-alexeyminki-z2te)
 */
class SolutionImpl2 : Solution {
    override fun isGood(nums: IntArray): Boolean {
        val flag = 1 shl 8
        val mask = flag - 1
        val n = nums.size
        nums[n - 1] -= flag
        for (i in 0 until n) {
            val num = nums[i] and mask
            if (num >= n || nums[num] > flag) return false
            nums[num] += flag
        }
        return true
    }
}
