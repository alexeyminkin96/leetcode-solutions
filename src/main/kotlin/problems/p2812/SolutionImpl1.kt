package problems.p2812

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `911 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `82.62 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n² log n)`
 * - Space: `O(n²)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-safest-path-in-a-grid/solutions/8370361/kotlin-on2logn-911ms-on2-primitives-by-a-m97z)
 */
class SolutionImpl1 : Solution {
    override fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val n = grid.size
        val inf = (n shl 1) + 1
        val grid = Array(n) { i -> IntArray(n) { j -> if (grid[i][j] == 1) 0 else inf } }

        fun spread(i: Int, j: Int, prev: Int): Int {
            grid[i][j] = Math.min(grid[i][j], prev + 1)
            return grid[i][j]
        }

        for (i in 0 until n) {
            var prev = inf
            for (j in 0 until n) prev = spread(i, j, prev)
            for (j in n - 1 downTo 0) prev = spread(i, j, prev)
        }
        for (j in 0 until n) {
            var prev = inf
            for (i in 0 until n) prev = spread(i, j, prev)
            for (i in n - 1 downTo 0) prev = spread(i, j, prev)
        }

        val pq = PriorityQueue<Int> { a, b -> b - a }
        fun nextCell(i: Int, j: Int, v: Int) {
            val cell = grid[i][j]
            if (cell == -1) return
            pq.add((Math.min(v, cell) shl 18) or (i shl 9) or j)
            grid[i][j] = -1
        }

        var v = grid[0][0]
        var i = 0
        var j = 0
        grid[0][0] = -1

        while (!(i == n - 1 && j == n - 1 || v == 0)) {
            if (i > 0) nextCell(i - 1, j, v)
            if (i < n - 1) nextCell(i + 1, j, v)
            if (j > 0) nextCell(i, j - 1, v)
            if (j < n - 1) nextCell(i, j + 1, v)
            val cur = pq.poll()
            v = cur shr 18
            i = (cur shr 9) and 511
            j = cur and 511
        }
        return v
    }
}