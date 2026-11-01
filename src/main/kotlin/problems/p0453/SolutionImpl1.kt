package problems.p0453

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `59.71 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-moves-to-equal-array-elements/solutions/8597142/kotlin-on-2ms-o1-by-alexeyminkin-3gro)
 */
class SolutionImpl1 : Solution {
    override fun minMoves(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        for (num in nums) if (num < min) min = num
        var res = 0
        for (num in nums) res += num - min
        return res
    }
}