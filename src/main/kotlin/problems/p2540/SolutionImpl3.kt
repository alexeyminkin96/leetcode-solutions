package problems.p2540

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.42 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-common-value/solutions/8276221/kotlin-on1n2-1ms-o1-hybrid-incremental-b-zpi1)
 */
class SolutionImpl3 : Solution {
    override fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        val n1 = nums1.size
        val n2 = nums2.size
        val shift1 = 32 - Integer.numberOfLeadingZeros(n1)
        val shift2 = 32 - Integer.numberOfLeadingZeros(n2)
        var i1 = 0
        var i2 = 0
        var num1 = nums1[i1]
        var num2 = nums2[i2]
        while (i1 < n1 && i2 < n2) {
            when {
                num1 < num2 -> {
                    if (i1 + shift1 < n1 && nums1[i1 + shift1] < num2) {
                        i1 = Arrays.binarySearch(nums1, i1 + 1 + shift1, n1, num2)
                        if (i1 < 0) i1 = -i1 - 1
                    } else while (i1 < n1 && nums1[i1] < num2) i1++
                    if (i1 < n1) num1 = nums1[i1]
                }

                num1 > num2 -> {
                    if (i2 + shift2 < n2 && nums2[i2 + shift2] < num1) {
                        i2 = Arrays.binarySearch(nums2, i2 + 1 + shift2, n2, num1)
                        if (i2 < 0) i2 = -i2 - 1
                    } else while (i2 < n2 && nums2[i2] < num1) i2++
                    if (i2 < n2) num2 = nums2[i2]
                }

                else -> return num1
            }
        }
        return -1
    }
}
