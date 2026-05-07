package problems.p3660

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `86.30 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-ix/solutions/8158589/kotlin-on-5ms-on-by-alexeyminkin-wn9a)
 */
class SolutionImpl1 : Solution {
    override fun maxValue(nums: IntArray): IntArray {
        val n = nums.size
        val prefMax = IntArray(n)
        prefMax[0] = nums[0]
        for (i in 1 until n)
            prefMax[i] = Math.max(prefMax[i - 1], nums[i])
        var min = nums[n - 1]
        for (i in n - 2 downTo 0) {
            if (prefMax[i] > min) prefMax[i] = prefMax[i + 1]
            min = Math.min(min, nums[i])
        }
        return prefMax
    }
}