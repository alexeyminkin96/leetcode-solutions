package problems.p2029

class SolutionImpl2 : Solution {
    override fun stoneGameIX(stones: IntArray): Boolean {
        val counts = IntArray(3)
        for (stone in stones) counts[stone % 3]++
        return if ((counts[0] and 1) == 0)
            counts[1] * counts[2] != 0
        else
            Math.abs(counts[1] - counts[2]) >= 3
    }
}