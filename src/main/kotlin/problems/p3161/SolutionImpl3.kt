package problems.p3161

import java.util.TreeSet

/**
 * **LeetCode Performance:**
 * - Runtime: `407 ms` (Beats `38.13%` of Kotlin submissions)
 * - Memory: `148.50 MB` (Beats `91.88%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(q log M)`
 * - Space: `O(M)`
 */
class SolutionImpl3 : Solution {
    override fun getResults(queries: Array<IntArray>): List<Boolean> {
        val d = IntArray(100_001)
        val walls = TreeSet<Int>()
        val tree = SegTree(100_001)
        val res = ArrayList<Boolean>()
        for (i in 0 until queries.size) {
            val query = queries[i]
            val x = query[1]
            if (query[0] == 1) {
                val lower = walls.lower(x) ?: 0
                d[x] = x - lower
                val higher = walls.higher(x) ?: 100_000
                d[higher] = higher - x
                walls.add(x)
                tree.update(x, d[x])
                tree.update(higher, d[higher])
            } else {
                val sz = query[2]
                val lower = walls.floor(x) ?: 0
                res.add(tree.query(0, x) >= sz || x - lower >= sz)
            }
        }
        return res
    }

    private class SegTree(size: Int) {
        private val tree = IntArray(size * 4)

        fun update(pos: Int, value: Int) {
            update(1, 0, tree.size / 4 - 1, pos, value)
        }

        private fun update(v: Int, l: Int, r: Int, pos: Int, value: Int) {
            if (l == r) {
                tree[v] = value
                return
            }

            val m = (l + r) shr 1
            if (pos <= m) update(v shl 1, l, m, pos, value)
            else update(v shl 1 or 1, m + 1, r, pos, value)

            tree[v] = Math.max(tree[v shl 1], tree[v shl 1 or 1])
        }

        fun query(left: Int, right: Int): Int {
            return query(1, 0, tree.size / 4 - 1, left, right)
        }

        private fun query(v: Int, l: Int, r: Int, ql: Int, qr: Int): Int {
            if (ql <= l && r <= qr) return tree[v]
            if (r < ql || qr < l) return 0

            val m = (l + r) shr 1
            return Math.max(
                query(v shl 1, l, m, ql, qr),
                query(v shl 1 or 1, m + 1, r, ql, qr)
            )
        }
    }
}