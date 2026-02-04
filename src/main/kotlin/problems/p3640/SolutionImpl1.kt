package problems.p3640

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `76.24 MB` (Beats `84.62%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/trionic-array-ii/solutions/7551865/kotlin-on-5ms-o1-by-alexeyminkin-tehv)
 */
class SolutionImpl1 : Solution {
    override fun maxSumTrionic(nums: IntArray): Long {
        val n = nums.size
        var i = 1
        var result = Long.MIN_VALUE
        while (i < n) {
            while (i < n && nums[i - 1] >= nums[i]) i++
            var sum = 0L

            if (!(i < n && nums[i - 1] < nums[i])) continue
            sum += nums[i++ - 1]
            while (i < n && nums[i - 1] < nums[i])
                sum = Math.max(sum + nums[i - 1], nums[i++ - 1].toLong())

            if (!(i < n && nums[i - 1] > nums[i])) continue
            sum += nums[i++ - 1]
            while (i < n && nums[i - 1] > nums[i])
                sum += nums[i++ - 1]

            var j = i
            if (!(j < n && nums[j - 1] < nums[j])) continue
            sum += nums[j++ - 1]
            while (j < n && nums[j - 1] < nums[j]) {
                sum += nums[j++ - 1]
                result = Math.max(result, sum)
            }
            sum += nums[j++ - 1]
            result = Math.max(result, sum)
        }
        return result
    }
}