package problems.p0462

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minMoves2(nums: IntArray): Int {
        Arrays.sort(nums)
        val median = nums[nums.size shr 1]
        var res = 0
        for (num in nums)
            res += Math.abs(median - num)
        return res
    }
}