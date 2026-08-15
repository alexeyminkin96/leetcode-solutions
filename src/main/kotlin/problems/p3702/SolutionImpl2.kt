package problems.p3702

class SolutionImpl2 : Solution {
    override fun longestSubsequence(nums: IntArray): Int {
        var xor = 0
        for (num in nums) xor = xor xor num
        if (xor != 0) return nums.size
        for (num in nums) if (num != 0) return nums.size - 1
        return 0
    }
}