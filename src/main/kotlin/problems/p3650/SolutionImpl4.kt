package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `124 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `150.93 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + m) log (n + m))`
 * - Space: `O(n + m)`
 */
class SolutionImpl4 : Solution {
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

        val visited = BooleanArray(n)
        val heap = PriorityQueue<Long>()
        heap.add(0)
        val last = n - 1

        while (!heap.isEmpty()) {
            val current = heap.poll()
            val node = (current % base).toInt()
            if (node == last) return (current / base).toInt()
            if (visited[node]) continue
            visited[node] = true
            for (next in nexts[node] ?: continue) {
                val nextNode = (next % base).toInt()
                if (!visited[nextNode])
                    heap.add(next + current - node)
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