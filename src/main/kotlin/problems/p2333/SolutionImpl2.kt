package problems.p2333

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.74 MB` (Beats `87.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + C)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-sum-of-squared-difference/solutions/8565442/kotlin-on-c-6ms-oc-by-alexeyminkin-py5m)
 */
class SolutionImpl2 : Solution {
    override fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
        val n = nums1.size
        val sort = IntArray(100_001)
        var max = 0
        for (i in 0 until n) {
            val num = Math.abs(nums1[i] - nums2[i])
            sort[num]++
            if (num > max) max = num
        }
        var changes = 0L + k1 + k2
        var i = max
        var changeCount = 0L
        while (i > 0) {
            val remove = changeCount + sort[i]
            if (remove > changes) break
            changes -= remove
            changeCount += sort[i--]
        }
        if (i == 0) return 0
        var res = 0L
        for (j in 1 until i)
            res += sort[j].toLong() * j * j
        val count = changeCount + sort[i]
        res += (count - changes) * i * i + changes * (i - 1) * (i - 1)
        return res
    }
}