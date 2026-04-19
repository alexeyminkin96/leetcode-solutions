package problems.p1855

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `64.13 MB` (Beats `54.55%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/solutions/7992246/kotlin-onm-4ms-o1-by-alexeyminkin-enzx)
 */
class SolutionImpl1 : Solution {
    override fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var maxDist = 0
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] <= nums2[j])
                maxDist = Math.max(maxDist, j++ - i)
            else if (i++ == j) j++
        }
        return maxDist
    }
}