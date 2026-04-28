package problems.p2033

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val ar = IntArray(m * n)
        var idx = 0
        val rem = grid[0][0] % x
        for (i in 0 until m) {
            val row = grid[i]
            for (j in 0 until n) {
                val cell = row[j]
                val div = cell / x
                if (cell - x * div != rem) return -1
                ar[idx++] = div
            }
        }
        Arrays.sort(ar)
        val med = ar[ar.size shr 1]
        var res = 0
        for (i in 0 until ar.size)
            res += Math.abs(ar[i] - med)
        return res
    }
}