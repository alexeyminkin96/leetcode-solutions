package problems.p3876

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `71.98 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/construct-uniform-parity-array-ii/solutions/8499487/kotlin-on-4ms-o1-by-alexeyminkin-hi0x)
 */
class SolutionImpl2 : Solution {
    override fun uniformArray(nums1: IntArray): Boolean {
        val mins = IntArray(2) { Int.MAX_VALUE }
        for (num in nums1) mins[num and 1] = Math.min(mins[num and 1], num)
        return mins[1] < mins[0] || mins[1] == Int.MAX_VALUE
    }
}