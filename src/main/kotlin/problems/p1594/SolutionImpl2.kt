package problems.p1594

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/solutions/7683029/kotlin-omn-2ms-on-by-alexeyminkin-od96)
 */
class SolutionImpl2 : Solution {
    override fun maxProductPath(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val min = LongArray(n + 1) { Long.MAX_VALUE }; min[1] = 1
        val max = LongArray(n + 1) { Long.MIN_VALUE }; max[1] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                val p1 = Math.min(min[j + 1], min[j]) * grid[i][j]
                val p2 = Math.max(max[j + 1], max[j]) * grid[i][j]
                min[j + 1] = Math.min(p1, p2)
                max[j + 1] = Math.max(p1, p2)
            }
        }
        return if (max[n] < 0) -1 else (max[n] % 1_000_000_007).toInt()
    }
}