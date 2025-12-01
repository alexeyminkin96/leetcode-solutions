package problems.p0041

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `99.32%` of Kotlin submissions)
 * - Memory: `62.19 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/first-missing-positive/solutions/7385498/kotlin-on-2ms-o1-by-alexeyminkin-ntvt)
 */
class SolutionImpl2 : Solution {
    override fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            val num = nums[i]
            if (num > 0 && num <= nums.size && num != nums[num - 1]) {
                nums[i] = nums[num - 1]
                nums[num - 1] = num
            } else i++
        }

        for (j in 0 until nums.size) {
            if (nums[j] != j + 1)
                return j + 1
        }

        return nums.size + 1
    }
}