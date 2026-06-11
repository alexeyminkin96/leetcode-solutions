package problems.p3558

/**
 * **LeetCode Performance:**
 * - Runtime: `103 ms` (Beats `79.18%` of Kotlin submissions)
 * - Memory: `133.96 MB` (Beats `55.20%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun assignEdgeWeights(edges: Array<IntArray>): Int {
        val mod = 1_000_000_007L
        val n = edges.size + 1
        val graph = Array(n + 1) { ArrayList<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        val stack = ArrayList<Node>()
        stack.add(Node(1, 0, 0))
        var depth = 0
        while (!stack.isEmpty()) {
            val node = stack.removeLast()
            for (child in graph[node.value])
                if (child != node.parent)
                    stack.add(Node(child, node.value, node.depth + 1))
            depth = Math.max(depth, node.depth)
        }
        var res = 1L
        for (i in 1 until depth)
            res = (res shl 1) % mod
        return res.toInt()
    }

    private data class Node(
        val value: Int,
        val parent: Int,
        val depth: Int,
    )
}