package problems.p2567

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun minimizeSum(nums: IntArray): Int {
        val n = nums.size
        Arrays.sort(nums)
        return minOf(nums[n - 1] - nums[2], nums[n - 2] - nums[1], nums[n - 3] - nums[0])
    }
}
