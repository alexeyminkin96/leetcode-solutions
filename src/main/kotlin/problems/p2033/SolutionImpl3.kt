package problems.p2033

class SolutionImpl3 : Solution {
    override fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val counts = IntArray(10_001 / x + 1)
        val rem = grid[0][0] % x
        for (i in 0 until m) {
            val row = grid[i]
            for (j in 0 until n) {
                val cell = row[j]
                val div = cell / x
                if (cell - x * div != rem) return -1
                counts[div]++
                row[j] = div
            }
        }
        var count = 0
        var med = -1
        val medCount = (m * n) shr 1
        while (count <= medCount) count += counts[++med]
        var res = 0
        for (i in 0 until m) {
            val row = grid[i]
            for (j in 0 until n)
                res += Math.abs(row[j] - med)
        }
        return res
    }
}