package problems.p3559

/**
 * **LeetCode Performance:**
 * - Runtime: `75 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `118.42 MB` (Beats `98.48%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + q) log n)`
 * - Space: `O(n log n)`
 */
class SolutionImpl1 : Solution {
    override fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007
        val n = edges.size + 1

        val head = IntArray(n + 1) { -1 }
        val to = IntArray(edges.size * 2)
        val next = IntArray(edges.size * 2)
        var edgeId = 0

        fun add(u: Int, v: Int) {
            to[edgeId] = v
            next[edgeId] = head[u]
            head[u] = edgeId++
        }

        for (e in edges) {
            add(e[0], e[1])
            add(e[1], e[0])
        }

        var log = 1
        while ((1 shl log) <= n) log++

        val up = Array(log) { IntArray(n + 1) }
        val depth = IntArray(n + 1)

        val stack = IntArray(n)
        var size = 0
        stack[size++] = 1
        up[0][1] = 0

        while (size > 0) {
            val node = stack[--size]

            var e = head[node]
            while (e != -1) {
                val nei = to[e]

                if (nei != up[0][node]) {
                    depth[nei] = depth[node] + 1
                    up[0][nei] = node

                    for (j in 1 until log) {
                        up[j][nei] = up[j - 1][up[j - 1][nei]]
                    }

                    stack[size++] = nei
                }

                e = next[e]
            }
        }

        val pow2 = IntArray(n + 1)
        pow2[0] = 1
        for (i in 1..n) {
            pow2[i] = (pow2[i - 1] * 2L % mod).toInt()
        }

        fun lca(a0: Int, b0: Int): Int {
            var a = a0
            var b = b0

            if (depth[a] < depth[b]) {
                val t = a
                a = b
                b = t
            }

            var diff = depth[a] - depth[b]
            var j = 0
            while (diff > 0) {
                if ((diff and 1) == 1) a = up[j][a]
                diff = diff shr 1
                j++
            }

            if (a == b) return a

            for (i in log - 1 downTo 0) {
                if (up[i][a] != up[i][b]) {
                    a = up[i][a]
                    b = up[i][b]
                }
            }

            return up[0][a]
        }

        val res = IntArray(queries.size)

        for (i in queries.indices) {
            val u = queries[i][0]
            val v = queries[i][1]

            val p = lca(u, v)
            val len = depth[u] + depth[v] - 2 * depth[p]

            res[i] = if (len == 0) 0 else pow2[len - 1]
        }

        return res
    }
}