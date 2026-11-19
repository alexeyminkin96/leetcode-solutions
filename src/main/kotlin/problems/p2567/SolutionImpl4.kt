package problems.p2567

class SolutionImpl4 : Solution {
    override fun minimizeSum(nums: IntArray): Int {
        val mins = IntArray(4) { Int.MAX_VALUE }
        val maxs = IntArray(4)
        for (num in nums) {
            mins[0] = num
            for (i in 0 until 3)
                if (mins[i] < mins[i + 1]) swapWithNext(mins, i) else break
            maxs[0] = num
            for (i in 0 until 3)
                if (maxs[i] > maxs[i + 1]) swapWithNext(maxs, i) else break
        }
        return minOf(maxs[3] - mins[1], maxs[2] - mins[2], maxs[1] - mins[3])
    }

    private fun swapWithNext(ints: IntArray, i: Int) {
        val t = ints[i]
        ints[i] = ints[i + 1]
        ints[i + 1] = t
    }
}
