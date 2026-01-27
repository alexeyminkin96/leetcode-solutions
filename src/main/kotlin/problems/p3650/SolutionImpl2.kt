package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `234 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `148.10 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log (n + m))`
 * - Space: `O(n + m)`
 */
class SolutionImpl2 : Solution {
    override fun minCost(n: Int, edges: Array<IntArray>): Int {
        val map = HashMap<Int, MutableList<IntArray>>()
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]

            val us = map[u]
            if (us != null) us.add(intArrayOf(v, w))
            else map[u] = mutableListOf(intArrayOf(v, w))

            val vs = map[v]
            if (vs != null) vs.add(intArrayOf(u, w * 2))
            else map[v] = mutableListOf(intArrayOf(u, w * 2))
        }

        val visited = HashSet<Int>()
        val heap = PriorityQueue<IntArray>(compareBy { it[1] })
        heap.add(intArrayOf(0, 0))

        while (heap.isNotEmpty()) {
            val no = heap.poll()
            val node = no[0]
            val weight = no[1]
            if (node == n - 1) return weight
            if (visited.contains(node)) continue
            visited.add(node)
            val nexts = map[node] ?: continue
            for (next in nexts) {
                if (!visited.contains(next[0]))
                    heap.add(intArrayOf(next[0], weight + next[1]))
            }
        }
        return -1
    }
}