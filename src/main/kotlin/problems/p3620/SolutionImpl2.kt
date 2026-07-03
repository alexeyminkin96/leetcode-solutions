package problems.p3620

class SolutionImpl2 : Solution {
    override fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val n = online.size
        val nodes = Array(n) { Node() }
        var minC = if (k < Int.MAX_VALUE) k.toInt() else Int.MAX_VALUE
        var maxC = 0
        val pCounts = IntArray(n)
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
            pCounts[v]++
        }

        val order = IntArray(n)
        var cur = 0
        var last = 0
        for (i in 0 until n)
            if (pCounts[i] == 0) order[last++] = i
        while (cur < last)
            for (child in nodes[order[cur++]].children)
                if (--pCounts[child] == 0) order[last++] = child

        minC -= 1
        var l = minC
        var r = maxC
        while (l < r) {
            val mid = l + ((r - l + 1) shr 1)
            val sums = LongArray(n) { Long.MAX_VALUE }
            sums[0] = 0
            for (i in 0 until n) {
                val s = sums[order[i]]
                if (s == Long.MAX_VALUE) continue
                val parent = nodes[order[i]]
                for (childIdx in 0 until parent.children.size)
                    if (parent.costs[childIdx] >= mid)
                        sums[parent.children[childIdx]] =
                            Math.min(sums[parent.children[childIdx]], s + parent.costs[childIdx])
            }
            if (sums[n - 1] <= k) l = mid
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