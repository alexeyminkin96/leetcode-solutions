package problems.p1351

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `52.82 MB` (Beats `16.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m log n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun countNegatives(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var result = m * n
        var j = n - 1

        for (i in 0 until m) {
            if (grid[i][0] < 0) break
            if (grid[i][j] < 0) {
                j = binarySearchDesc(grid[i], 0, j, 0)
                if (j < 0) j = -j - 2
                else while (grid[i][j + 1] >= 0) j++
            }
            result -= j + 1
        }
        return result
    }

    private fun binarySearchDesc(a: IntArray, fromIndex: Int, toIndex: Int, key: Int): Int {
        var low = fromIndex
        var high = toIndex - 1

        while (low <= high) {
            val mid = (low + high) ushr 1
            val midVal = a[mid]

            if (midVal > key) low = mid + 1
            else if (midVal < key) high = mid - 1
            else return mid
        }
        return -(low + 1)
    }
}