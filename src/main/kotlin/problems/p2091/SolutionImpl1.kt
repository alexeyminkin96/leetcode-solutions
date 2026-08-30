package problems.p2091

class SolutionImpl1 : Solution {
    override fun minimumDeletions(nums: IntArray): Int {
        var iMin = 0
        var iMax = 0
        val n = nums.size
        for (i in 1 until n)
            if (nums[i] < nums[iMin]) iMin = i
            else if (nums[i] > nums[iMax]) iMax = i
        val l = Math.min(iMin, iMax)
        val r = Math.max(iMin, iMax)
        return n - maxOf(l, r - 1 - l, n - 1 - r)
    }
}