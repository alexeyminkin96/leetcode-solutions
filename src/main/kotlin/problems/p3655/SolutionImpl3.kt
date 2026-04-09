package problems.p3655

import java.math.BigInteger

class SolutionImpl3 : Solution {
    override fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val m = BigInteger.valueOf(mod.toLong())
        val e = BigInteger.valueOf(mod.toLong() - 2)
        fun modPow(v: Int): Long = BigInteger.valueOf(v.toLong()).modPow(e, m).toLong()
        queries
            .groupBy { it[2] to it[0] % it[2] }
            .forEach { (k, v) ->
                val events = v
                    .flatMap { listOf(it[0] to it[3].toLong(), it[1] + 1 to modPow(it[3])) }
                    .sortedByDescending { it.first }
                    .toMutableList()
                var curEv = events.removeLast()
                var mul = 1L
                outer@ for (i in curEv.first until nums.size step k.first) {
                    while (i >= curEv.first) {
                        mul = curEv.second * mul % mod
                        curEv = events.removeLastOrNull() ?: break@outer
                    }
                    nums[i] = ((mul * nums[i]) % mod).toInt()
                }
            }
        var res = nums[0]
        for (i in 1 until nums.size) res = res xor nums[i]
        return res
    }
}