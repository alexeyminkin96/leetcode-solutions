package problems.p3190

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `42.18 MB` (Beats `90%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Loop array
 * - Count numbers, which don't divide by 3
 *
 * **Techniques:**
 * - Math
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/solutions/7367923/kotlin-on-0ms-o1-by-alexeyminkin-2mog)
 */
class SolutionImpl1 : Solution {
    override fun minimumOperations(nums: IntArray): Int {
        var count = 0
        for (i in 0 until nums.size)
            if (nums[i] % 3 != 0) count++
        return count
    }
}
