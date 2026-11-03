package problems.p3736

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `90.91%` of Kotlin submissions)
 * - Memory: `49.13 MB` (Beats `27.27%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/solutions/8600089/kotlin-on-2ms-o1-by-alexeyminkin-suxx)
 */
class SolutionImpl1 : Solution {
    override fun minMoves(nums: IntArray): Int {
        var max = 0
        var sum = 0
        for (num in nums) {
            sum += num
            max = Math.max(max, num)
        }
        return nums.size * max - sum
    }
}