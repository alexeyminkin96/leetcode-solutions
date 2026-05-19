package problems.p2540

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        val min = if (nums1.size < nums2.size) nums1 else nums2
        val max = if (nums1.size < nums2.size) nums2 else nums1
        val maxLog = 32 - Integer.numberOfLeadingZeros(max.size)
        return if (min.size * maxLog > min.size + max.size) twoPointers(min, max)
        else binarySearch(min, max)
    }

    private fun twoPointers(nums1: IntArray, nums2: IntArray): Int {
        val n1 = nums1.size
        val n2 = nums2.size
        var i1 = 0
        var i2 = 0
        while (i1 < n1 && i2 < n2) {
            val diff = nums1[i1] - nums2[i2]
            when {
                diff < 0 -> i1++
                diff > 0 -> i2++
                else -> return nums1[i1]
            }
        }
        return -1
    }

    private fun binarySearch(min: IntArray, max: IntArray): Int {
        val maxSize = max.size
        var prev = -1
        var prevBinSer = 0
        for (i in 0 until min.size) {
            val cur = min[i]
            if (cur == prev || cur < max[prevBinSer]) continue
            prev = cur
            val binSer = Arrays.binarySearch(max, prevBinSer, maxSize, cur)
            if (binSer >= 0) return cur
            prevBinSer = -binSer - 1
        }
        return -1
    }
}