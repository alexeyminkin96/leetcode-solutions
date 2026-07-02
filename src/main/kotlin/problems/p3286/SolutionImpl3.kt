package problems.p3286

class SolutionImpl3 : Solution {
    override fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val m = grid.size
        val n = grid[0].size
        val mat = Array(m) { i -> IntArray(n) { j -> -1 } }
        val s = IntArray(n * m)
        var sI = 0
        fun see(i: Int, j: Int, h: Int) {
            val nextHealth = h - grid[i][j]
            if (nextHealth <= 0 || nextHealth <= mat[i][j]) return
            s[sI++] = (i shl 6) or j
            mat[i][j] = nextHealth
        }
        see(0, 0, health)
        while (sI != 0) {
            val cur = s[--sI]
            val i = cur shr 6
            val j = cur and 63
            val h = mat[i][j]
            if (i == m - 1 && j == n - 1) return true
            if (i > 0) see(i - 1, j, h)
            if (i < m - 1) see(i + 1, j, h)
            if (j > 0) see(i, j - 1, h)
            if (j < n - 1) see(i, j + 1, h)
        }
        return false
    }
}