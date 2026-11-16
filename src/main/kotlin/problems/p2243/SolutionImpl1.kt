package problems.p2243

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.90 MB` (Beats `6.25%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/calculate-digit-sum-of-a-string/solutions/8614684/kotlin-on-1ms-on-by-alexeyminkin-ace5)
 */
class SolutionImpl1 : Solution {
    override fun digitSum(s: String, k: Int): String {
        val n = s.length
        var start = 0
        val digs = s.toCharArray()
        while (n - start > k) {
            var digsIdx = n
            for (groupStart in (n - start - 1) / k * k + start downTo start step k) {
                var sum = 0
                for (i in groupStart until Math.min(groupStart + k, n))
                    sum += digs[i] - '0'
                do {
                    digs[--digsIdx] = '0' + sum % 10
                    sum /= 10
                } while (sum > 0)
            }
            start = digsIdx
        }
        return String(digs, start, n - start)
    }
}