package problems.p0960

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.57 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m^2)`
 * - Space: `O(n * m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/delete-columns-to-make-sorted-iii/solutions/7430969/kotlin-onm2-10ms-onm-by-alexeyminkin-wox5)
 */
class SolutionImpl1 : Solution {
    override fun minDeletionSize(strs: Array<String>): Int {
        val charArrays = Array(strs.size) { strs[it].toCharArray() }
        var longestSorted = 0
        val dp = IntArray(strs[0].length)
        for (r in 1 until dp.size) {
            left@ for (l in r - 1 downTo 0) {
                if (dp[r] >= dp[l] + 1) continue@left
                for (i in 0 until charArrays.size)
                    if (charArrays[i][l] > charArrays[i][r]) continue@left
                dp[r] = dp[l] + 1
                if (dp[r] > longestSorted) longestSorted = dp[r]
            }
        }
        return dp.size - (longestSorted + 1)
    }
}
