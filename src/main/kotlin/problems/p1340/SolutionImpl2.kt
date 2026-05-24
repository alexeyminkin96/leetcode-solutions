package problems.p1340

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.10 MB` (Beats `86.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * d)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-v/solutions/8291273/kotlin-ond-6ms-on-2-solutions-by-alexeym-s2xo)
 */
class SolutionImpl2 : Solution {
    override fun maxJumps(arr: IntArray, d: Int): Int {
        val n = arr.size
        val dp = IntArray(n)
        fun findMax(i: Int): Int {
            if (dp[i] != 0) return dp[i]
            val curNum = arr[i]
            var maxDp = 0
            for (j in i - 1 downTo Math.max(i - d, 0))
                if (arr[j] < curNum) maxDp = Math.max(maxDp, findMax(j)) else break
            for (j in i + 1..Math.min(i + d, n - 1))
                if (arr[j] < curNum) maxDp = Math.max(maxDp, findMax(j)) else break
            dp[i] = maxDp + 1
            return dp[i]
        }

        var res = 0
        for (i in 0 until n)
            res = Math.max(res, findMax(i))
        return res
    }
}