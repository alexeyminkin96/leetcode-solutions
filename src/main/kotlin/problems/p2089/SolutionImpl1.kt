package problems.p2089

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.00 MB` (Beats `25.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-target-indices-after-sorting-array/solutions/8579164/kotlin-on-0ms-o1-by-alexeyminkin-wahd)
 */
class SolutionImpl1 : Solution {
    override fun targetIndices(nums: IntArray, target: Int): IntArray {
        var less = 0
        var count = 0
        for (num in nums)
            when {
                num < target -> less++
                num == target -> count++
            }
        return IntArray(count) { it + less }
    }
}