package problems.p3620

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `42 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `125.94 MB` (Beats `81.82%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) * log c)` c - max cost
 * - Space: `O(n + m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/network-recovery-pathways/solutions/8384106/kotlin-onmlogc-42ms-onm-primitives-only-p19pd)
 */
class SolutionImpl3 : Solution {
    override fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val n = online.size
        var minC = if (k < Int.MAX_VALUE) k.toInt() else Int.MAX_VALUE
        var maxC = 0
        val pCounts = IntArray(n)
        val cCounts = IntArray(n)
        var all = 0
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            if (!online[u] || !online[v]) continue
            pCounts[v]++
            cCounts[u]++
            all++
        }

        val children = IntArray(all)
        val costs = IntArray(all)
        val iStart = IntArray(n + 1)
        for (i in 0 until n)
            iStart[i + 1] = iStart[i] + cCounts[i]
        val iLast = Arrays.copyOf(iStart, iStart.size)

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val c = edge[2]
            if (!online[u] || !online[v]) continue
            children[iLast[u]] = v
            costs[iLast[u]++] = c
            minC = Math.min(minC, c)
            maxC = Math.max(maxC, c)
        }

        val order = IntArray(n)
        var cur = 0
        var last = 0
        for (i in 0 until n)
            if (pCounts[i] == 0) order[last++] = i
        while (cur < last) {
            val u = order[cur++]
            while (iLast[u] > iStart[u])
                if (--pCounts[children[--iLast[u]]] == 0) order[last++] = children[iLast[u]]
        }

        minC -= 1
        var l = minC
        var r = maxC
        while (l < r) {
            val mid = l + ((r - l + 1) shr 1)
            val sums = LongArray(n) { Long.MAX_VALUE }
            sums[0] = 0
            for (i in 0 until n) {
                val u = order[i]
                if (sums[u] > k) continue
                for (v in iStart[u] until iStart[u + 1])
                    if (costs[v] >= mid)
                        sums[children[v]] = Math.min(sums[children[v]], sums[u] + costs[v])
            }
            if (sums[n - 1] <= k) l = mid
            else r = mid - 1
        }

        return if (l == minC) -1 else l
    }
}