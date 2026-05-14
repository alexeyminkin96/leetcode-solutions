package problems.p2784

class SolutionImpl1 : Solution {
    override fun isGood(nums: IntArray): Boolean {
        val n = nums.size
        val counts = IntArray(n)
        counts[n - 1] = -1
        for (i in 0 until n)
            if (nums[i] >= n || ++counts[nums[i]] > 1) return false
        return true
    }
}