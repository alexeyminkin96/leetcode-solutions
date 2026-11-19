package problems.p2567

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minimizeSum(nums: IntArray): Int {
        val n = nums.size
        Arrays.sort(nums)
        var idx = 1
        for (i in 1 until n)
            if (nums[i] - nums[i - 1] < nums[idx] - nums[idx - 1]) idx = i

        for (j in 0 until 2)
            when (maxOf(nums[1] - nums[0], nums[idx] - nums[idx - 1], nums[n - 1] - nums[n - 2])) {
                nums[1] - nums[0] -> nums[0] = nums[1]
                nums[n - 1] - nums[n - 2] -> nums[n - 1] = nums[n - 2]
                else -> nums[idx] = nums[idx - 1]
            }

        return nums[n - 1] - nums[0] + minOf(nums[1] - nums[0], nums[idx] - nums[idx - 1], nums[n - 1] - nums[n - 2])
    }
}

