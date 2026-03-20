package problems.p3567

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `11 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.25 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((m - k) * (n - k) * k^2 * log(k^2))`
 * - Space: `O(k^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/solutions/7674987/kotlin-om-kn-kk2logk2-11ms-ok2-brute-for-l9vs)
 */
class SolutionImpl1 : Solution {
    override fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val result = Array(grid.size - k + 1) { IntArray(grid[0].size - k + 1) }
        val smSize = k * k
        val sm = IntArray(smSize)
        for (y in 0 until result.size) {
            for (x in 0 until result[0].size) {
                var smi = 0
                for (i in y until y + k)
                    for (j in x until x + k)
                        sm[smi++] = grid[i][j]
                Arrays.sort(sm)
                var min = Int.MAX_VALUE
                for (a in 1 until smSize)
                    if (sm[a] - sm[a - 1] > 0 && sm[a] - sm[a - 1] < min)
                        min = sm[a] - sm[a - 1]
                result[y][x] = if (min == Int.MAX_VALUE) 0 else min
            }
        }
        return result
    }
}