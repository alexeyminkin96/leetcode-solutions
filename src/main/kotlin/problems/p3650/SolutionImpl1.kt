package problems.p3650

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `XX ms` (Beats `YY%` of Kotlin submissions)
 * - Memory: `ZZ MB` (Beats `WW%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(?)`
 * - Space: `O(?)`
 *
 * **Notes:**
 * - Any important remarks about this solution
 */
class SolutionImpl1 : Solution {
    override fun minCost(n: Int, edges: Array<IntArray>): Int {
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
            edges
                .onEach {
                    if (it[0] == node && !visited.contains(it[1]))
                        heap.add(intArrayOf(it[1], weight + it[2]))
                    else if (it[1] == node && !visited.contains(it[0]))
                        heap.add(intArrayOf(it[0], weight + it[2] * 2))
                }
        }
        return -1
    }
}