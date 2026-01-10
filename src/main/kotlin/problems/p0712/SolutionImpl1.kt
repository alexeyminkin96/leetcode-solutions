package problems.p0712

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `91.67%` of Kotlin submissions)
 * - Memory: `46.48 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m)`
 * - Space: `O(n*m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/solutions/7483038/kotlin-onm-21ms-onm-by-alexeyminkin-vo4i)
 */
class SolutionImpl1 : Solution {
    override fun minimumDeleteSum(s1: String, s2: String): Int {
        val nChars = s1.toCharArray()
        val mChars = s2.toCharArray()
        val nSize = nChars.size
        val mSize = mChars.size
        val dp = Array(nSize + 1) { IntArray(mSize + 1) }
        for (s in 0 until nSize + mSize) {
            for (n in Math.max(0, s - mSize)..Math.min(s, nSize)) {
                val m = s - n
                if (n < nSize && dp[n][m] > dp[n + 1][m])
                    dp[n + 1][m] = dp[n][m]
                if (m < mSize && dp[n][m] > dp[n][m + 1])
                    dp[n][m + 1] = dp[n][m]
                if (n < nSize && m < mSize && nChars[n] == mChars[m])
                    dp[n + 1][m + 1] = Math.max(dp[n][m] + nChars[n].code * 2, dp[n + 1][m + 1])
            }
        }
        var sum = 0
        for (c in nChars) sum += c.code
        for (c in mChars) sum += c.code
        return sum - dp[nSize][mSize]
    }
}
