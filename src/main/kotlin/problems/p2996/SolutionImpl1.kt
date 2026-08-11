package problems.p2996

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun missingInteger(nums: IntArray): Int {
        val n = nums.size
        var sum = nums[0]
        var i = 1
        while (i < n && nums[i] == nums[i - 1] + 1) sum += nums[i++]
        if (i == 1) sum++
        Arrays.sort(nums, i, n)
        while (i < n)
            if (nums[i++] > sum) return sum
            else if (sum == nums[i - 1]) sum++
        return sum
    }
}