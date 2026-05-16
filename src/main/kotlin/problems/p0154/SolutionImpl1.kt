package problems.p0154

class SolutionImpl1 : Solution {
    override fun findMin(nums: IntArray): Int {
        for (i in 1 until nums.size)
            if (nums[i] < nums[i - 1]) return nums[i]
        return nums[0]
    }
}