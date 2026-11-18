package problems.p2911

/**
 * **LeetCode Performance:**
 * - Runtime: `90 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `51.87 MB` (Beats `25.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n³ log n + kn²)`
 * - Space: `O(n² + kn)`
 */
class SolutionImpl1 : Solution {
    override fun minimumChanges(s: String, k: Int): Int {
        val n = s.length
        val mins = Array(n) { IntArray(n) }
        val s = s.toCharArray()
        for (l in 0 until n - 1) {
            for (r in l + 1 until n) {
                val length = r - l + 1
                var min = Int.MAX_VALUE
                for (div in 1..length / 2) {
                    if (length % div != 0) continue
                    var count = 0
                    for (start in l until l + div) {
                        var left = start
                        var right = start + length - div
                        while (left < right) {
                            if (s[left] != s[right]) count++
                            left += div
                            right -= div
                        }
                    }
                    min = Math.min(min, count)
                }
                mins[l][r] = min
            }
        }

        val dp = Array(k + 1) { IntArray(n + 1) { n } }
        dp[0][0] = 0
        for (group in 1..k) {
            for (i in (group shl 1)..n) {
                var min = n
                for (j in ((group - 1) shl 1)..i - 2)
                    min = Math.min(min, dp[group - 1][j] + mins[j][i - 1])
                dp[group][i] = min
            }
        }
        return dp[k][n]
    }
}