package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `73 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `142.59 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log m)`
 * - Space: `O(n + m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/solutions/7528549/kotlin-onmlogm-73ms-onm-by-alexeyminkin-wdow)
 */
class SolutionImpl6 : Solution {
    private val bitCount = 16   //n <= 5 * 10^4
    private val nodeMask = (1L shl bitCount) - 1
    override fun minCost(n: Int, edges: Array<IntArray>): Int {
        val nexts = arrayOfNulls<MutableList<Long>>(n)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2].toLong()
            getOrPut(nexts, u, (w shl bitCount) or v.toLong())
            getOrPut(nexts, v, (w shl bitCount + 1) or u.toLong())
        }

        val heap = PriorityQueue<Long>()
        heap.add(0)
        val bestWeights = LongArray(n)
        val last = n - 1

        while (!heap.isEmpty()) {
            val current = heap.poll()
            val node = (current and nodeMask).toInt()
            if (node == last) return (current shr bitCount).toInt()
            if (bestWeights[node] != current) continue
            for (next in nexts[node] ?: continue) {
                val nextNode = (next and nodeMask).toInt()
                val nextWeight = current - node + next
                if (bestWeights[nextNode] == 0L || bestWeights[nextNode] > nextWeight) {
                    heap.add(nextWeight)
                    bestWeights[nextNode] = nextWeight
                }
            }
        }
        return -1
    }

    private fun getOrPut(map: Array<MutableList<Long>?>, key: Int, value: Long) {
        var list = map[key]
        if (list == null) {
            list = ArrayList()
            map[key] = list
        }
        list.add(value)
    }
}