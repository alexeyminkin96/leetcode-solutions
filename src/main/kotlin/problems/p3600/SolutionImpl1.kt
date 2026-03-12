package problems.p3600

class SolutionImpl1 : Solution {
    override fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
        var l = 0
        var r = findR(edges)
        while (l < r) {
            val mid = (l + r + 1) ushr 1
            if (check(mid, n, edges, k)) l = mid else r = mid - 1
        }
        return if (check(l, n, edges, k)) l else -1
    }

    private fun findR(edges: Array<IntArray>): Int {
        var min = Int.MAX_VALUE
        var max = 0
        for (e in edges)
            if (e[3] == 1) min = Math.min(min, e[2])
            else max = Math.max(max, e[2] shl 1)
        return if (min != Int.MAX_VALUE) min else max
    }

    private fun check(x: Int, n: Int, edges: Array<IntArray>, k: Int): Boolean {
        val dsu = DSU(n)
        for (e in edges)
            if (e[3] == 1) if (!dsu.union(e[0], e[1])) return false
        for (e in edges)
            if (e[3] == 0 && e[2] >= x) dsu.union(e[0], e[1])
        var upgs = 0
        for (e in edges)
            if (e[3] == 0 && e[2] < x && (e[2] shl 1) >= x && dsu.union(e[0], e[1]))
                if (++upgs > k) return false
        return dsu.count == 1
    }

    private class DSU(n: Int) {
        private val parent: IntArray = IntArray(n) { it }
        var count: Int = n

        fun union(l: Int, r: Int): Boolean {
            val pl = find(l)
            val pr = find(r)
            if (pl == pr) return false
            parent[pl] = pr
            count--
            return true
        }

        private fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }
    }
}