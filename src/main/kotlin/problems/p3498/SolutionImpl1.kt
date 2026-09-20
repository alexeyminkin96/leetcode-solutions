package problems.p3498

/**
 * **LeetCode Performance**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.43 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/reverse-degree-of-a-string/solutions/8531623/kotlin-on-1ms-o1-by-alexeyminkin-1xs5)
 */
class SolutionImpl1 : Solution {
    override fun reverseDegree(s: String): Int {
        var res = 0
        for (i in 0 until s.length)
            res += ('z' + 1 - s[i]) * (i + 1)
        return res
    }
}