package problems.p2747

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `23 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `194.40 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(L log L + Q log Q)`
 * - Space: `O(L + Q + n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-zero-request-servers/solutions/8603548/kotlin-oqlogqllogl-23ms-oqln-primitives-cc42l)
 */
class SolutionImpl2 : Solution {
    override fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
        val qSize = queries.size
        val queryAndIdx = LongArray(qSize) { (queries[it].toLong() shl 32) or it.toLong() }
        Arrays.sort(queryAndIdx)
        val lSize = logs.size
        val timeAndServer = LongArray(lSize) { (logs[it][1].toLong() shl 32) or logs[it][0].toLong() }
        Arrays.sort(timeAndServer)
        val serverCounts = IntArray(n + 1)
        var logL = 0
        var logR = 0
        var unActive = n
        val res = IntArray(qSize)
        for (i in 0 until qSize) {
            val end = (queryAndIdx[i] shr 32).toInt()
            while (logR < lSize && timeAndServer[logR] shr 32 <= end)
                if (serverCounts[timeAndServer[logR++].toInt()]++ == 0) unActive--
            val start = end - x
            while (logL < lSize && timeAndServer[logL] shr 32 < start)
                if (--serverCounts[timeAndServer[logL++].toInt()] == 0) unActive++
            res[queryAndIdx[i].toInt()] = unActive
        }
        return res
    }
}