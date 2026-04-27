package problems.p1391

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `77.31 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/submissions/1989418897)
 */
class SolutionImpl3 : Solution {
    //L-0,U-1,R-2,B-3
    override fun hasValidPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        fun hasValid(from: Int): Boolean {
            var from = from
            var i = 0
            var j = 0
            while (i < m && i >= 0 && j < n && j >= 0) {
                from = when (from * 10 + grid[i][j]) {
                    1, 16, 34 -> 0
                    21, 15, 33 -> 2
                    12, 3, 24 -> 1
                    32, 5, 26 -> 3
                    else -> return false
                }
                if (i == m - 1 && j == n - 1) return true
                if (i != 0 && j != 0) grid[i][j] = 0
                if (from and 1 == 1) i += 2 - from else j += 1 - from
            }
            return false
        }
        return when (grid[0][0]) {
            1, 3 -> hasValid(0)
            4 -> hasValid(3) || hasValid(2)
            else -> hasValid(1)
        }
    }
}