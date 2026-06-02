package problems.p3633

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.42 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/solutions/8308255/kotlin-on-2ms-o1-by-alexeyminkin-8i9h)
 */
class SolutionImpl1 : Solution {
    override fun earliestFinishTime(lST: IntArray, lD: IntArray, wST: IntArray, wD: IntArray): Int {
        fun findMin(fST: IntArray, fD: IntArray, sST: IntArray, sD: IntArray): Int {
            var fMin = 3000
            for (i in 0 until fST.size) fMin = Math.min(fMin, fST[i] + fD[i])
            var res = 3000
            for (i in 0 until sST.size) res = Math.min(res, Math.max(fMin, sST[i]) + sD[i])
            return res
        }
        return Math.min(findMin(lST, lD, wST, wD), findMin(wST, wD, lST, lD))
    }
}