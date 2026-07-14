package problems.p3336

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun subsequencePairCount(nums: IntArray): Int {
        val mod = 1_000_000_007
        var size = 0
        for (num in nums) size = Math.max(size, num + 1)
        var dp = Array(size) { IntArray(size) }
        dp[0][0] = 1
        var next = Array(size) { IntArray(size) }
        var max = 0
        fun next(i: Int, j: Int, count: Int) {
            next[i][j] += count
            if (next[i][j] >= mod) next[i][j] -= mod
        }
        for (num in nums) {
            for (i in 0..max) {
                for (j in 0..max) {
                    val count = dp[i][j]
                    if (count == 0) continue
                    next(i, j, count)
                    next(gcd(num, i), j, count)
                    next(i, gcd(num, j), count)
                }
            }
            val buf = dp
            dp = next
            next = buf
            for (row in next) Arrays.fill(row, 0)
            max = Math.max(max, num)
        }
        var res = 0L
        for (i in 1 until size) res += dp[i][i]
        return (res % mod).toInt()
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}