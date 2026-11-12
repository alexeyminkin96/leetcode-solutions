package problems.p3105

class SolutionImpl2 : Solution {
    override fun longestMonotonicSubarray(nums: IntArray): Int {
        var res = 1
        var inc = 1
        var dec = 1
        for (i in 1 until nums.size) {
            val diff = nums[i] - nums[i - 1]
            inc = if (diff > 0) inc + 1 else 1
            dec = if (diff < 0) dec + 1 else 1
            res = maxOf(res, inc, dec)
        }
        return res
    }
}