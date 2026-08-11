package problems.p2996

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.52 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/solutions/8454220/kotlin-on-0ms-o1-by-alexeyminkin-qiat)
 */
class SolutionImpl3 : Solution {
    override fun missingInteger(nums: IntArray): Int {
        val n = nums.size
        var sum = nums[0]
        var i = 1
        while (i < n && nums[i] == nums[i - 1] + 1) sum += nums[i++]
        if (i == 1) sum++
        if (sum > 50) return sum
        var pres = 0L
        while (i < n) pres = pres or (1L shl nums[i++])
        while ((pres shr sum) and 1 == 1L) sum++
        return sum
    }
}