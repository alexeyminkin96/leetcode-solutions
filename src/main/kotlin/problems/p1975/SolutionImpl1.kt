package problems.p1975

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.90 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/four-divisors/solutions/7464455/kotlin-onsqrtm-9ms-om-caching-by-alexeym-tppd)
 */
class SolutionImpl1 : Solution {
    override fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var min = Math.abs(matrix[0][0])
        var negCount = 0
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix.size) {
                var num = matrix[i][j]
                if (num < 0) {
                    num *= -1
                    negCount++
                }
                sum += num
                if (num < min) min = num
            }
        }
        if (negCount % 2 == 1)
            sum -= min * 2
        return sum
    }
}