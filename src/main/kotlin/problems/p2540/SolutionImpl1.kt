package problems.p2540

class SolutionImpl1 : Solution {
    override fun getCommon(nums1: IntArray, nums2: IntArray): Int {
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
}