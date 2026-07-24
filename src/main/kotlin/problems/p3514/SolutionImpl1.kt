package problems.p3514

/**
 * **LeetCode Performance:**
 * - Runtime: `117 ms` (Beats `84.88%` of Kotlin submissions)
 * - Memory: `59.55 MB` (Beats `87.21%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/solutions/8424129/kotlin-onm-117ms-om-by-alexeyminkin-6of8)
 */
class SolutionImpl1 : Solution {
    override fun uniqueXorTriplets(nums: IntArray): Int {
        val dp = Array(4) { BooleanArray(2048) }
        dp[0][0] = true
        for (k in 0 until dp.size - 1)
            for (xor in 0 until dp[k].size)
                if (!dp[k][xor]) continue
                else for (num in nums) dp[k + 1][num xor xor] = true
        var res = 0
        for (bol in dp[dp.size - 1]) if (bol) res++
        return res
    }
}