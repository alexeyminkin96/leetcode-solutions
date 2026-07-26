package problems.p0628

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.89 MB` (Beats `55.17%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-product-of-three-numbers/solutions/8424185/kotlin-on-1ms-o1-by-alexeyminkin-k7yg)
 */
class SolutionImpl1 : Solution {
    override fun maximumProduct(nums: IntArray): Int {
        var max = -1001
        var prevMax = -1001
        var prevPrevMax = -1001
        var min = 1001
        var prevMin = 1001
        for (num in nums) {
            if (num > prevPrevMax) {
                prevPrevMax = num
                if (prevPrevMax > prevMax) {
                    val t = prevPrevMax
                    prevPrevMax = prevMax
                    prevMax = t
                }
                if (prevMax > max) {
                    val t = prevMax
                    prevMax = max
                    max = t
                }
            }
            if (num < prevMin) {
                prevMin = num
                if (prevMin < min) {
                    val t = prevMin
                    prevMin = min
                    min = t
                }
            }
        }
        return Math.max(max * prevMax * prevPrevMax, max * min * prevMin)
    }
}