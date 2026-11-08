package problems.p1267

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `81.20 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(mn)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-servers-that-communicate/solutions/8605571/kotlin-omn-2ms-on-by-alexeyminkin-5jse)
 */
class SolutionImpl2 : Solution {
    override fun countServers(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val colCounts = IntArray(n)

        fun columnCount(j: Int): Int {
            if (colCounts[j] > 0) return colCounts[j]
            for (i in 0 until m)
                colCounts[j] += grid[i][j]
            return colCounts[j]
        }

        var res = 0
        for (i in 0 until m) {
            var rowCount = 0
            var lastJ = -1
            for (j in 0 until n) {
                if (grid[i][j] == 0) continue
                rowCount++
                lastJ = j
            }
            if (rowCount != 1 || columnCount(lastJ) > 1) res += rowCount
        }

        return res
    }
}