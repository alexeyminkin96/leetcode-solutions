package problems.p1914

/**
 * **LeetCode Performance:**
 * - Runtime: `210 ms` (Beats `91.83%` of Kotlin submissions)
 * - Memory: `48.77 MB` (Beats `51.92%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(m * n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/cyclically-rotating-a-grid/solutions/8264405/kotlin-omn-210ms-omn-by-alexeyminkin-n2nv)
 */
class SolutionImpl1 : Solution {
    override fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val res = Array(m) { IntArray(n) }
        for (p in 0 until Math.min(m, n) / 2) {
            val h = m - p * 2
            val w = n - p * 2
            val l = (h + w) * 2 - 4
            val k = k % l
            for (i in 0 until l)
                res[toY((i + k) % l, h, w) + p][toX((i + k) % l, h, w) + p] = grid[toY(i, h, w) + p][toX(i, h, w) + p]
        }
        return res
    }

    private fun toX(i: Int, h: Int, w: Int): Int =
        when {
            i < h -> 0
            i < h + w - 1 -> i - (h - 1)
            i < h * 2 + w - 2 -> w - 1
            else -> h * 2 + w * 2 - 4 - i
        }

    private fun toY(i: Int, h: Int, w: Int): Int =
        when {
            i < h -> i
            i < h + w - 1 -> h - 1
            i < h * 2 + w - 2 -> h * 2 + w - 3 - i
            else -> 0
        }
}