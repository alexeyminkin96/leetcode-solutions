package problems.p2685

class SolutionImpl1 : Solution {
    override fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val nodes = Array(n) { Node(it) }
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            nodes[a].neighbors.add(b)
            nodes[b].neighbors.add(a)
        }

        var componentSize = 0
        fun visit(node: Node): Int {
            node.visited = true
            componentSize++
            var neighbourCount = node.neighbors.size
            for (neighbor in node.neighbors)
                if (!nodes[neighbor].visited && visit(nodes[neighbor]) != neighbourCount) neighbourCount = -1
            return neighbourCount
        }

        var res = 0
        for (node in nodes) {
            componentSize = 0
            if (!node.visited && visit(node) == componentSize - 1) res++
        }
        return res
    }

    private data class Node(
        val v: Int,
        val neighbors: MutableList<Int> = mutableListOf(),
        var visited: Boolean = false
    )
}