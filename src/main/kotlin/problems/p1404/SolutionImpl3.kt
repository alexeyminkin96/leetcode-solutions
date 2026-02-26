package problems.p1404

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.33 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/solutions/7610466/kotlin-on-0ms-o1-by-alexeyminkin-yx16)
 */
class SolutionImpl3 : Solution {
    override fun numSteps(s: String): Int {
        var count = 0
        var carry = 0
        for (i in s.length - 1 downTo 1) {
            val num = s[i] - '0' + carry
            val rem = num and 1
            count += rem + 1
            carry = (num + rem) ushr 1
        }
        return count + carry
    }
}
