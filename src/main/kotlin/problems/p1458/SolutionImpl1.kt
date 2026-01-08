package problems.p1458

/**
 * **LeetCode Performance:**
 * - Runtime: `20 ms` (Beats `60.00%` of Kotlin submissions)
 * - Memory: `46.42 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*m)`
 * - Space: `O(n*m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/max-dot-product-of-two-subsequences/solutions/7477789/kotlin-onm-20ms-onm-not-recursion-by-ale-xci8)
 */
class SolutionImpl1 : Solution {
    override fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val sizeN = nums1.size
        val sizeM = nums2.size
        val dp = Array(sizeN + 1) { IntArray(sizeM + 1) { -1_000_000 } }
        for (sum in 0 until sizeN + sizeM) {
            for (n in 0..Math.min(sum, sizeN)) {
                val m = sum - n
                if (m > sizeM) continue
                if (n < sizeN && dp[n][m] > dp[n + 1][m])
                    dp[n + 1][m] = dp[n][m]
                if (m < sizeM && dp[n][m] > dp[n][m + 1])
                    dp[n][m + 1] = dp[n][m]
                if (n < sizeN && m < sizeM)
                    dp[n + 1][m + 1] = maxOf(dp[n][m] + nums1[n] * nums2[m], nums1[n] * nums2[m], dp[n + 1][m + 1])
            }
        }
        return dp[sizeN][sizeM]
    }
}