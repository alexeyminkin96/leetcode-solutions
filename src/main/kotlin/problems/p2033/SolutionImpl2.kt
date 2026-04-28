package problems.p2033

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `81.47 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/solutions/8107332/kotlin-omn-5ms-oc-count-sort-by-alexeymi-ww3t)
 */
class SolutionImpl2 : Solution {
    override fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val counts = IntArray(10_001 / x + 1)
        val rem = grid[0][0] % x
        for (i in 0 until m) {
            val row = grid[i]
            for (j in 0 until n) {
                val cell = row[j]
                val div = cell / x
                if (cell - x * div != rem) return -1
                counts[div]++
            }
        }
        var count = 0
        var med = -1
        val medCount = (m * n) shr 1
        while (count <= medCount) count += counts[++med]
        var res = 0
        for (i in 0 until counts.size) res += Math.abs(i - med) * counts[i]
        return res
    }
}