package problems.p3286

import java.util.PriorityQueue

class SolutionImpl2 : Solution {
    override fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val mat = Array(m) { i -> IntArray(n) { j -> grid[i][j] } }
        val p = PriorityQueue<Int> { a, b -> b - a }
        fun see(i: Int, j: Int, h: Int) {
            if (h <= mat[i][j]) return
            p.add(((h - mat[i][j]) shl 12) or (i shl 6) or j)
            mat[i][j] = health
        }
        see(0, 0, health)
        while (!p.isEmpty()) {
            val c = p.poll()
            val h = c shr 12
            val i = (c shr 6) and 63
            val j = c and 63
            if (i == m - 1 && j == n - 1) return true
            if (i > 0) see(i - 1, j, h)
            if (i < m - 1) see(i + 1, j, h)
            if (j > 0) see(i, j - 1, h)
            if (j < n - 1) see(i, j + 1, h)
        }
        return false
    }
}