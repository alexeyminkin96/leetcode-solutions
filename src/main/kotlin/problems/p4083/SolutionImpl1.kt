package problems.p4083

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.12 MB` (Beats `75.86%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/solutions/8583539/kotlin-on-2ms-o1-by-alexeyminkin-airs)
 */
class SolutionImpl1 : Solution {
    override fun minDeletions(nums: IntArray): Int {
        var res = 0
        var prev = 0
        for (num in nums)
            if (num == prev) res++
            else prev = num
        return res
    }
}