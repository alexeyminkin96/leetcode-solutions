package problems.p1340

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `15 ms` (Beats `0.00%` of Kotlin submissions)
 * - Memory: `47.54 MB` (Beats `53.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n + n * d)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-v/solutions/8291273/kotlin-ond-6ms-on-2-solutions-by-alexeym-s2xo)
 */
class SolutionImpl1 : Solution {
    override fun maxJumps(arr: IntArray, d: Int): Int {
        val bits = 10
        val mask = (1 shl bits) - 1
        val n = arr.size
        val sort = IntArray(n) { (arr[it] shl bits) or it }
        Arrays.sort(sort)
        val dp = IntArray(n)
        for (i in n - 1 downTo 0) {
            val curIdx = sort[i] and mask
            val curNum = arr[curIdx]
            val curDp = dp[curIdx]
            for (j in curIdx - 1 downTo Math.max(curIdx - d, 0)) {
                if (arr[j] >= curNum) break
                dp[j] = Math.max(dp[j], curDp + 1)
            }
            for (j in curIdx + 1..Math.min(curIdx + d, n - 1)) {
                if (arr[j] >= curNum) break
                dp[j] = Math.max(dp[j], curDp + 1)
            }
        }
        var res = 0
        for (i in 0 until n)
            res = Math.max(res, dp[i])
        return res + 1
    }
}