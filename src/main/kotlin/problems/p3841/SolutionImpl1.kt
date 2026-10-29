package problems.p3841

import java.util.Arrays

/**
 * **LeetCode Performance**
 * - Runtime: `139 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `248.85 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O((n + q) log n)`
 * - Space: `O(n log n)`
 */
class SolutionImpl1 : Solution {
    override fun palindromePath(n: Int, edges: Array<IntArray>, s: String, queries: Array<String>): List<Boolean> {
        val s = s.toCharArray()
        val counts = IntArray(n)

        for (edge in edges) {
            counts[edge[0]]++
            counts[edge[1]]++
        }

        val starts = IntArray(n)
        for (i in 1 until n)
            starts[i] = starts[i - 1] + counts[i - 1]
        val ends = Arrays.copyOf(starts, starts.size)
        val connections = IntArray((n - 1) shl 1)
        for (edge in edges) {
            connections[ends[edge[0]]++] = edge[1]
            connections[ends[edge[1]]++] = edge[0]
        }

        val xorToRoot = IntArray(n)

        val log = 32 - Integer.numberOfLeadingZeros(n)
        val up = Array(log) { IntArray(n) { -1 } }
        val depth = IntArray(n)

        val dfsIdxIn = IntArray(n)
        val dfsIdxOut = IntArray(n)

        var dfsIdx = 0
        fun dfs(i: Int, parent: Int) {
            up[0][i] = parent
            for (k in 1 until log) {
                val p = up[k - 1][i]
                if (p == -1) break
                up[k][i] = up[k - 1][p]
            }
            dfsIdxIn[i] = dfsIdx++
            xorToRoot[i] = xorToRoot[i] xor bit(s[i])
            for (k in starts[i] until ends[i]) {
                val e = connections[k]
                if (e == parent) continue
                depth[e] = depth[i] + 1
                xorToRoot[e] = xorToRoot[i]
                dfs(e, i)
            }
            dfsIdxOut[i] = dfsIdx - 1
        }

        dfs(0, -1)

        fun lca(n1: Int, n2: Int): Int {
            var u = if (depth[n1] > depth[n2]) n1 else n2
            var v = if (depth[n1] > depth[n2]) n2 else n1
            var diff = depth[u] - depth[v]
            var k = 0

            while (diff > 0) {
                if (diff and 1 == 1) u = up[k][u]
                diff = diff shr 1
                k++
            }
            if (u == v) return u

            for (k in log - 1 downTo 0) {
                if (up[k][u] != up[k][v]) {
                    u = up[k][u]
                    v = up[k][v]
                }
            }

            return up[0][u]
        }

        val fenwick = Fenwick(n)
        val res = ArrayList<Boolean>()
        for (query in queries) {
            val ns = query.split(" ")
            if (ns[0] == "query") {
                val n1 = ns[1].toInt()
                val n2 = ns[2].toInt()
                val xor = bit(s[lca(n1, n2)]) xor
                    xorToRoot[n1] xor fenwick.query(dfsIdxIn[n1]) xor
                    xorToRoot[n2] xor fenwick.query(dfsIdxIn[n2])
                res.add(xor == xor.takeHighestOneBit())
            } else {
                val node = ns[1].toInt()
                val c = ns[2][0]
                if (s[node] == c) continue
                fenwick.update(dfsIdxIn[node], dfsIdxOut[node], bit(s[node]) xor bit(c))
                s[node] = c
            }
        }
        return res
    }

    private fun bit(c: Char): Int {
        return 1 shl (c - 'a')
    }

    private class Fenwick(n: Int) {
        private val tree = IntArray(n + 1)

        private fun update(idx: Int, delta: Int) {
            var i = idx + 1
            while (i < tree.size) {
                tree[i] = tree[i] xor delta
                i += i and -i
            }
        }

        fun update(l: Int, r: Int, delta: Int) {
            update(l, delta)
            update(r + 1, delta)
        }

        fun query(idx: Int): Int {
            var i = idx + 1
            var xor = 0
            while (i > 0) {
                xor = xor xor tree[i]
                i -= i and -i
            }
            return xor
        }
    }
}