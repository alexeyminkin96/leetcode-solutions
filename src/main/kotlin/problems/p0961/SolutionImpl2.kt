package problems.p0961

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.42 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/solutions/7458131/kotlin-on-0ms-o1-exactly-one-pass-no-ext-7vc0)
 */
class SolutionImpl2 : Solution {
    override fun repeatedNTimes(nums: IntArray): Int {
        for (i in 0 until 4) {
            if (nums[i] == nums[(i + 1) % 4] || nums[i] == nums[(i + 2) % 4]) return nums[i]
        }
        var i = 4
        while (nums[i] != nums[i + 1]) i += 2
        return nums[i]
    }
}