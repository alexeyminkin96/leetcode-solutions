package problems.p2747

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
        val q = queries.size
        val queryAndIdx = Array(q) { intArrayOf(queries[it], it) }
        Arrays.sort(queryAndIdx, compareBy { it[0] })
        Arrays.sort(logs, compareBy { it[1] })
        val map = HashMap<Int, Int>()
        var logL = 0
        var logR = 0
        var unActive = n
        val res = IntArray(q)
        for (i in 0 until q) {
            val end = queryAndIdx[i][0]
            while (logR < logs.size && logs[logR][1] <= end)
                map.compute(logs[logR++][0]) { _, v ->
                    val prev = (v ?: 0)
                    if (prev == 0) unActive--
                    prev + 1
                }
            val start = end - x
            while (logL < logs.size && logs[logL][1] < start)
                map.compute(logs[logL++][0]) { _, v ->
                    if (v!! == 1) unActive++
                    v - 1
                }
            res[queryAndIdx[i][1]] = unActive
        }
        return res
    }
}