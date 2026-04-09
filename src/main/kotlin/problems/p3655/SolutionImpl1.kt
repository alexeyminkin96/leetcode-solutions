package problems.p3655

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `224 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `119.01 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + q) * sqrt(n))`
 * - Space: `O(n * sqrt(n))`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/solutions/7843442/kotlin-onqsqrtn-224ms-onq-by-alexeyminki-2u8n)
 */
class SolutionImpl1 : Solution {
    override fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val sqrt = Math.sqrt(nums.size.toDouble()).toInt()
        val map = HashMap<Long, MutableList<IntArray>>()
        for (i in 0 until queries.size) {
            val query = queries[i]
            if (query[2] > sqrt) {
                val v = query[3]
                for (j in query[0]..query[1] step query[2])
                    nums[j] = ((nums[j].toLong() * v) % mod).toInt()
                continue
            }
            val key = query[2].toLong() shl 17 or (query[0] % query[2]).toLong()
            var list = map[key]
            if (list == null) {
                list = ArrayList()
                map[key] = list
            }
            list.add(query)
        }

        for ((k, v) in map) {
            val events = LongArray(v.size shl 1) {
                val query = v[it shr 1]
                if (it and 1 == 0) (query[0].toLong() shl 30) or query[3].toLong()
                else ((query[1].toLong() + 1) shl 30) or modPow(query[3], mod)
            }
            Arrays.sort(events)
            var evIdx = 0
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