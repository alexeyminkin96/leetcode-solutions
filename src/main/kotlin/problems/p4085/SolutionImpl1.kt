package problems.p4085

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `248.61 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-root-of-a-colored-tree/solutions/8583613/kotlin-on-10ms-on-by-alexeyminkin-51fj)
 */
class SolutionImpl1 : Solution {
    override fun findColoredRoot(edges: Array<IntArray>, colors: String): Int {
        val n = edges.size + 1
        val parents = IntArray(n) { -1 }
        val children = IntArray(n)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val uColor = colors[u]
            val vColor = colors[v]
            if (uColor == vColor) return -1
            val parent: Int
            val child: Int
            if (uColor == 'R' && vColor == 'B'
                || uColor == 'B' && vColor == 'W'
                || uColor == 'W' && vColor == 'R'
            ) {
                parent = u
                child = v
            } else {
                parent = v
                child = u
            }
            if (parents[child] != -1) return -1
            parents[child] = parent
            if (++children[parent] > 2) return -1
        }
        var res = -1
        for (i in 0 until n)
            if (parents[i] == -1) if (res != -1) return -1 else res = i
        return res
    }
}