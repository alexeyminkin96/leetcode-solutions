package problems.p3600

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `43 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `145.82 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + edges.size) * log m)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
        val parentMust = IntArray(n) { it }
        var min = Int.MAX_VALUE
        var max = 0
        var must0Count = n
        for (e in edges)
            if (e[3] == 1) {
                if (!union(e[0], e[1], parentMust)) return -1
                else must0Count--
                min = Math.min(min, e[2])
            } else max = Math.max(max, e[2] shl 1)
        val parentCopy = Arrays.copyOf(parentMust, n)
        var l = 0
        var r = if (min != Int.MAX_VALUE) min else max
        while (l < r) {
            val mid = (l + r + 1) ushr 1
            if (check(mid, must0Count, edges, k, parentCopy)) l = mid else r = mid - 1
            System.arraycopy(parentMust, 0, parentCopy, 0, n)
        }
        return if (check(l, must0Count, edges, k, parentCopy)) l else -1
    }

    private fun check(x: Int, must0Count: Int, edges: Array<IntArray>, k: Int, parent: IntArray): Boolean {
        var count = must0Count
        for (e in edges)
            if (e[3] == 0 && e[2] >= x) if (union(e[0], e[1], parent)) count--
        var upgs = 0
        for (e in edges)
            if (e[3] == 0 && e[2] < x && (e[2] shl 1) >= x && union(e[0], e[1], parent))
                if (++upgs > k) return false else count--
        return count == 1
    }

    private fun union(l: Int, r: Int, parent: IntArray): Boolean {
        val pl = find(l, parent)
        val pr = find(r, parent)
        if (pl == pr) return false
        parent[pl] = pr
        return true
    }

    private fun find(x: Int, parent: IntArray): Int {
        if (parent[x] != x) parent[x] = find(parent[x], parent)
        return parent[x]
    }
}