package problems.p3513

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `69.70 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-unique-xor-triplets-i/solutions/8423640/kotlin-o1-1ms-o1-by-alexeyminkin-26kk)
 */
class SolutionImpl1 : Solution {
    override fun uniqueXorTriplets(nums: IntArray): Int {
        return if (nums.size < 3) return nums.size else nums.size.takeHighestOneBit() shl 1
    }
}