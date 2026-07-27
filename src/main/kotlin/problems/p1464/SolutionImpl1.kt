package problems.p1464

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.46 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/solutions/8424197/kotlin-on-0ms-o1-by-alexeyminkin-9frv)
 */
class SolutionImpl1 : Solution {
    override fun maxProduct(nums: IntArray): Int {
        var max = 0
        var prevMax = 0
        for (num in nums) {
            if (num > max) {
                prevMax = max
                max = num
            } else if (num > prevMax)
                prevMax = num
        }
        return (max - 1) * (prevMax - 1)
    }
}