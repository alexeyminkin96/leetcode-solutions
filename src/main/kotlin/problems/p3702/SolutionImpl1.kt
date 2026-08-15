package problems.p3702

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `72.24 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/solutions/8462716/kotlin-on-3ms-o1-by-alexeyminkin-xwrh)
 */
class SolutionImpl1 : Solution {
    override fun longestSubsequence(nums: IntArray): Int {
        var xor = 0
        var nulls = 0
        for (num in nums) if (num == 0) nulls++ else xor = xor xor num
        return if (nulls == nums.size) 0 else if (xor == 0) nums.size - 1 else nums.size
    }
}