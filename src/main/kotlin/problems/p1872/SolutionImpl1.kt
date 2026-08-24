package problems.p1872

class SolutionImpl1 : Solution {
    override fun stoneGameVIII(stones: IntArray): Int {
        for (i in 1 until stones.size)
            stones[i] += stones[i - 1]
        var dp = stones[stones.size - 1]
        for (i in stones.size - 2 downTo 1)
            dp = Math.max(dp, stones[i] - dp)
        return dp
    }
}