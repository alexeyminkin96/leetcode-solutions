package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `74 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `137.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log m)`
 * - Space: `O(n + m)`
 */
class SolutionImpl5 : Solution {
    private val base = 100_000  //n <= 5 * 10^4
    override fun minCost(n: Int, edges: Array<IntArray>): Int {
        val nexts = arrayOfNulls<MutableList<Long>>(n)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2].toLong()
            getOrPut(nexts, u, w * base + v)
            getOrPut(nexts, v, w * 2 * base + u)
        }

        val heap = PriorityQueue<Long>()
        heap.add(0)
        val bestWeights = LongArray(n) { Long.MAX_VALUE }
        bestWeights[0] = 0
        val last = n - 1

        while (!heap.isEmpty()) {
            val current = heap.poll()
            val node = (current % base).toInt()
            if (node == last) return (current / base).toInt()
            if (bestWeights[node] != current) continue
            for (next in nexts[node] ?: continue) {
                val nextNode = (next % base).toInt()
                val nextWeight = next + current - node
                if (bestWeights[nextNode] > nextWeight) {
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