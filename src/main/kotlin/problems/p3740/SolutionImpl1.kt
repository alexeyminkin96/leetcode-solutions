package problems.p3740

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.38 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/solutions/7856813/kotlin-on-1ms-on-primitives-by-alexeymin-c5vy)
 */
class SolutionImpl1 : Solution {
    override fun minimumDistance(nums: IntArray): Int {
        val n = nums.size + 1
        val first = IntArray(n) { -n }
        val second = IntArray(n) { -n }
        var res = n
        for (i in 0 until n - 1) {
            val num = nums[i]
            res = Math.min(res, i - first[num])
            first[num] = second[num]
            second[num] = i
        }
        return if (res == n) -1 else res shl 1
    }
}