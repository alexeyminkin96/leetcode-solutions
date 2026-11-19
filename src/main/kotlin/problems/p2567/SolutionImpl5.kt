package problems.p2567

class SolutionImpl5 : Solution {
    override fun minimizeSum(nums: IntArray): Int {
        val sort = IntArray(7) { if (it < 3) Int.MAX_VALUE else 0 }
        fun swapWithNext(i: Int) {
            val t = sort[i]
            sort[i] = sort[i + 1]
            sort[i + 1] = t
        }
        for (num in nums) {
            sort[3] = num
            for (i in 3 downTo 1)
                if (sort[i - 1] > sort[i]) swapWithNext(i - 1) else break
            sort[3] = num
            for (i in 3 until 6)
                if (sort[i] > sort[i + 1]) swapWithNext(i) else break
        }
        return minOf(sort[6] - sort[2], sort[5] - sort[1], sort[4] - sort[0])
    }
}
