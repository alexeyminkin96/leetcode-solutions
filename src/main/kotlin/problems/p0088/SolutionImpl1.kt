package problems.p0088

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.31 MB` (Beats `93.36%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/merge-sorted-array/solutions/7388185/kotlin-onm-0ms-o1-by-alexeyminkin-d5xj)
 */
class SolutionImpl1 : Solution {
    override fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i1 = m - 1
        var i2 = n - 1

        for (i in nums1.size - 1 downTo 0) {
            if (i2 < 0 || i1 >= 0 && nums1[i1] > nums2[i2])
                nums1[i] = nums1[i1--]
            else
                nums1[i] = nums2[i2--]
        }
    }
}