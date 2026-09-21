package problems.p3524

/**
 * **LeetCode Performance**
 * - Runtime: `17 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.85 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n * k)`
 * - Space: `O(k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-x-value-of-array-i/solutions/8532841/kotlin-okn-17ms-ok-by-alexeyminkin-jwzb)
 */
class SolutionImpl1 : Solution {
    override fun resultArray(nums: IntArray, k: Int): LongArray {
        val counts = LongArray(k)
        val next = LongArray(k)
        val dp = LongArray(k)
        for (num in nums) {
            val numRem = num % k
            for (rem in 0 until k)
                next[rem * numRem % k] += dp[rem]
            next[numRem]++
            for (rem in 0 until k) {
                counts[rem] += next[rem]
                dp[rem] = next[rem]
                next[rem] = 0
            }
        }
        return counts
    }
}