package problems.p0041

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `47.62%` of Kotlin submissions)
 * - Memory: `70.17 MB` (Beats `10.88%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun firstMissingPositive(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            if (nums[i] <= 0 || nums[i] > nums.size) {
                nums[i] = 0
            }
        }

        var i = 0
        while (i < nums.size) {
            if (nums[i] > 0) {
                val buf = nums[i] - 1
                if (nums[buf] > 0)
                    nums[i] = nums[buf]
                else nums[i++] = 0
                nums[buf] = -1
            } else i++
        }

        for (i in 0 until nums.size) {
            if (nums[i] == 0)
                return i + 1
        }

        return nums.size + 1
    }
}