package problems.p2141

/**
 * **LeetCode Performance:**
 * - Runtime: `17 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.12 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(batteries.size * log(sum(batteries) / n))`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun maxRunTime(n: Int, batteries: IntArray): Long {
        var min = batteries[0]
        var sumArray = 0L
        for (i in 0 until batteries.size) {
            if (batteries[i] < min) min = batteries[i]
            sumArray += batteries[i]
        }

        var l = min.toLong()
        var r = sumArray / n

        while (l < r) {
            val m = (r + l + 1) / 2
            var sum = 0L
            for (i in 0 until batteries.size) {
                sum += minOf(batteries[i].toLong(), m)
            }
            if (sum >= n * m) l = m
            else r = m - 1
        }
        return l
    }
}