package problems.p3286

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `98.51%` of Kotlin submissions)
 * - Memory: `49.80 MB` (Beats `95.90%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n * log(m * n))`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-a-safe-walk-through-a-grid/solutions/8382919/kotlin-omnlogmn-14ms-omn-by-alexeyminkin-s47r)
 */
class SolutionImpl1 : Solution {
    override fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val mat = Array(m) { i -> IntArray(n) { j -> grid[i][j] } }
        val pq = PriorityQueue<Cell> { a, b -> b.h - a.h }
        fun see(i: Int, j: Int, h: Int) {
            if (h <= mat[i][j]) return
            pq.add(Cell(i, j, h - mat[i][j]))
            mat[i][j] = health
        }
        see(0, 0, health)
        while (!pq.isEmpty()) {
            val cur = pq.poll()
            val i = cur.i
            val j = cur.j
            val h = cur.h
            if (i == m - 1 && j == n - 1) return true
            if (i > 0) see(i - 1, j, h)
            if (i < m - 1) see(i + 1, j, h)
            if (j > 0) see(i, j - 1, h)
            if (j < n - 1) see(i, j + 1, h)
        }
        return false
    }

    private data class Cell(
        val i: Int,
        val j: Int,
        val h: Int
    )
}