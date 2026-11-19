package problems.p2567

/**
 * **LeetCode Performance**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.00 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-score-by-changing-two-elements/solutions/8617884/kotlin-on-3ms-o1-by-alexeyminkin-3dx1)
 */
class SolutionImpl3 : Solution {
    override fun minimizeSum(nums: IntArray): Int {
        var min0 = Int.MAX_VALUE
        var min1 = Int.MAX_VALUE
        var min2 = Int.MAX_VALUE
        var max2 = 0
        var max1 = 0
        var max0 = 0
        for (num in nums) {
            if (num < min2)
                min2 = num
            if (min2 < min1) {
                val t = min2
                min2 = min1
                min1 = t
            }
            if (min1 < min0) {
                val t = min1
                min1 = min0
                min0 = t
            }

            if (num > max2)
                max2 = num
            if (num > max1) {
                val t = max2
                max2 = max1
                max1 = t
            }
            if (num > max0) {
                val t = max1
                max1 = max0
                max0 = t
            }
        }
        return minOf(max2 - min0, max1 - min1, max0 - min2)
    }
}
