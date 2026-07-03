package problems.p3620

class SolutionImpl1 : Solution {
    override fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val n = online.size
        val nodes = Array(n) { Node() }
        var minC = if (k < Int.MAX_VALUE) k.toInt() else Int.MAX_VALUE
        var maxC = 0
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val c = edge[2]
            if (!online[u] || !online[v]) continue
            nodes[v].parents.add(u)
            nodes[u].children.add(v)
            nodes[u].costs.add(c)
            minC = Math.min(minC, c)
            maxC = Math.max(maxC, c)
        }

        fun path(nodeId: Int, score: Int, sum: Long): Boolean {
            if (nodeId == n - 1) return true
            val node = nodes[nodeId]
            for (i in 0 until node.children.size) {
                if (node.costs[i] < score || sum + node.costs[i] > k) continue
                if (path(node.children[i], score, sum + node.costs[i])) return true
            }
            return false
        }

        minC -= 1
        var l = -1
        var r = maxC
        while (l < r) {
            val mid = l + ((r - l + 1) shr 1)
            if (path(0, mid, 0)) l = mid
            else r = mid - 1
        }

        return if (l == minC) -1 else l
    }

    private data class Node(
        val children: MutableList<Int> = mutableListOf(),
        val costs: MutableList<Int> = mutableListOf(),
        val parents: MutableList<Int> = mutableListOf()
    )
}