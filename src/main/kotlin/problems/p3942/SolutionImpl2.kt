package problems.p3942

class SolutionImpl2 : Solution {
    override fun minOperations(nums: IntArray): Int {
        val n = nums.size
        if (n <= 2) return nums[0]
        var prev = nums[n - 1]
        var gapIdx = -1
        val step = if (nums[1] - nums[0] == 1 || nums[2] - nums[1] == 1) 1 else -1
        for (i in 0 until n) {
            val num = nums[i]
            if (num - prev != step)
                if (Math.abs(num - prev) != n - 1) return -1 else gapIdx = i
            prev = num
        }
        return Math.min(gapIdx + Math.max(-step, 0), n - gapIdx + 1 + Math.max(step, 0))
    }
}