package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `207 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `133.27 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log (n + m))`
 * - Space: `O(n + m)`
 */
class SolutionImpl3 : Solution {
    private val base = 100_000  //n <= 5 * 10^4
    override fun minCost(n: Int, edges: Array<IntArray>): Int {
        val map = HashMap<Long, MutableList<Long>>()
        for (edge in edges) {
            val u = edge[0].toLong()
            val v = edge[1].toLong()
            val w = edge[2].toLong()
            getOrPut(map, u, w * base + v)
            getOrPut(map, v, w * 2 * base + u)
        }

        val visited = HashSet<Long>()
        val heap = PriorityQueue<Long>()
        heap.add(0)
        val last = (n - 1).toLong()

        while (!heap.isEmpty()) {
            val current = heap.poll()
            val node = current % base
            if (node == last) return (current / base).toInt()
            if (visited.contains(node)) continue
            visited.add(node)
            for (next in map[node] ?: continue) {
                val nextNode = next % base
                if (!visited.contains(nextNode))
                    heap.add(next + current - node)
            }
        }
        return -1
    }

    private fun getOrPut(map: HashMap<Long, MutableList<Long>>, key: Long, value: Long) {
        var list = map[key]
        if (list == null) {
            list = ArrayList()
            map[key] = list
        }
        list.add(value)
    }
}