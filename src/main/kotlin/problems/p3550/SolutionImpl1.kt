package problems.p3550

/**
 * **LeetCode Performance**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.85 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/solutions/8537556/kotlin-on-1ms-o1-by-alexeyminkin-dc9t)
 */
class SolutionImpl1 : Solution {
    override fun smallestIndex(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var digSum = 0
            var num = nums[i]
            while (num != 0) {
                digSum += num % 10
                num /= 10
            }
            if (digSum == i) return i
        }
        return -1
    }
}