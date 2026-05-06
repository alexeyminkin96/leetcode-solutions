package problems.p1861

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `96.17 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotating-the-box/solutions/8154004/kotlin-omn-6ms-o1-by-alexeyminkin-1llb)
 */
class SolutionImpl1 : Solution {
    override fun rotateTheBox(boxGrid: Array<CharArray>): Array<CharArray> {
        val m = boxGrid.size
        val n = boxGrid[0].size
        val res = Array(n) { CharArray(m) { '.' } }
        for (i in 0 until m) {
            var empty = n - 1
            for (j in n - 1 downTo 0) {
                when (boxGrid[i][j]) {
                    '*' -> {
                        res[j][m - 1 - i] = '*'
                        empty = j - 1
                    }

                    '#' -> res[empty--][m - 1 - i] = '#'
                }
            }
        }
        return res
    }
}