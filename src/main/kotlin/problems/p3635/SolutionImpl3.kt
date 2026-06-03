package problems.p3635

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `75.12 MB` (Beats `40.91%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/solutions/8310637/kotlin-onm-3ms-o1-by-alexeyminkin-kigw)
 */
class SolutionImpl3 : Solution {
    override fun earliestFinishTime(lST: IntArray, lD: IntArray, wST: IntArray, wD: IntArray): Int {
        val landIsSmaller = lST.size < wST.size
        val minST = if (landIsSmaller) lST else wST
        val minD = if (landIsSmaller) lD else wD
        val maxST = if (landIsSmaller) wST else lST
        val maxD = if (landIsSmaller) wD else lD
        var res = Int.MAX_VALUE
        var fMin = Int.MAX_VALUE
        for (i in 0 until minST.size) {
            val m = minST[i] + minD[i]
            if (m < fMin) fMin = m
        }
        var sMin = Int.MAX_VALUE
        for (i in 0 until maxST.size) {
            val r = maxST[i] + maxD[i]
            if (r < sMin) sMin = r
            val m = maxD[i] + if (fMin > maxST[i]) fMin else maxST[i]
            if (m < res) res = m
        }
        if (sMin >= res) return res
        for (i in 0 until minST.size) {
            val r = minD[i] + if (sMin > minST[i]) sMin else minST[i]
            if (r < res) res = r
        }
        return res
    }
}