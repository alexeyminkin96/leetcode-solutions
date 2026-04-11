package problems.p3741

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `87.52 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/solutions/7867244/kotlin-on-4ms-on-primitives-by-alexeymin-k2zr)
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