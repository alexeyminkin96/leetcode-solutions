package problems.p2574

class SolutionImpl1 : Solution {
    override fun leftRightDifference(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        for (i in 1 until nums.size)
            res[i] = res[i - 1] + nums[i - 1]
        var r = 0
        for (i in nums.size - 2 downTo 0) {
            r += nums[i + 1]
            res[i] = Math.abs(res[i] - r)
        }
        return res
    }
}