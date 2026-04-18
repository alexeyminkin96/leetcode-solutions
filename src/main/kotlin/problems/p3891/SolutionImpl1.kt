package problems.p3891

class SolutionImpl1 : Solution {
    override fun minIncrease(nums: IntArray): Long {
        fun makePeak(i: Int): Int = Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0)
        return if (nums.size and 1 == 1) {
            var odCount = 0L
            for (i in 1 until nums.size - 1) if (i and 1 == 1) odCount += makePeak(i)
            odCount
        } else {
            var evCount = 0L
            for (i in 2 until nums.size - 1) if (i and 1 == 0) evCount += makePeak(i)
            var res = evCount
            var odCount = 0L
            for (i in 1 until nums.size - 1) {
                if (i and 1 == 0) continue
                odCount += makePeak(i)
                evCount -= makePeak(i + 1)
                res = Math.min(res, odCount + evCount)
            }
            res
        }
    }
}