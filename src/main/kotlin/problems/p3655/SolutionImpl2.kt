package problems.p3655

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val map = group(queries)

        for ((k, events) in map) {
            Arrays.sort(events, 1, events.size)
            var evIdx = 1
            var evNum = (events[evIdx] shr 30).toInt()
            var evV = events[evIdx++] and ((1 shl 30) - 1)
            var mul = 1L
            outer@ for (i in evNum until nums.size step k.shr(17).toInt()) {
                while (i >= evNum) {
                    mul = evV * mul % mod
                    if (evIdx < events.size) {
                        evNum = (events[evIdx] shr 30).toInt()
                        evV = events[evIdx++] and ((1 shl 30) - 1)
                    } else break@outer
                }
                nums[i] = ((mul * nums[i]) % mod).toInt()
            }
        }

        var res = nums[0]
        for (i in 1 until nums.size) res = res xor nums[i]
        return res
    }

    private fun group(queries: Array<IntArray>): HashMap<Long, LongArray> {
        val mod = 1_000_000_007
        val counts = HashMap<Long, Int>()
        for (i in 0 until queries.size) {
            val query = queries[i]
            val key = query[2].toLong() shl 17 or (query[0] % query[2]).toLong()
            counts[key] = (counts[key] ?: 0) + 1
        }
        val map = HashMap<Long, LongArray>()
        for ((k, v) in counts)
            map[k] = LongArray((v shl 1) + 1)

        for (i in 0 until queries.size) {
            val query = queries[i]
            val key = query[2].toLong() shl 17 or (query[0] % query[2]).toLong()
            val ar = map[key]!!
            ar[(++ar[0]).toInt()] = (query[0].toLong() shl 30) or query[3].toLong()
            ar[(++ar[0]).toInt()] = ((query[1].toLong() + 1) shl 30) or modPow(query[3], mod)
        }
        return map
    }

    private fun modPow(v: Int, mod: Int): Long {
        var base = v.toLong()
        var exp = mod - 2
        var res = 1L
        while (exp > 0) {
            if ((exp and 1) == 1) res = (res * base) % mod
            base = base * base % mod
            exp = exp shr 1
        }
        return res
    }
}