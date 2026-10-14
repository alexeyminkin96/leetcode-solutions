package problems.p3723

/**
 * **LeetCode Performance:**
 * - Runtime: `22 ms` (Beats `33.33%` of Kotlin submissions)
 * - Memory: `102.29 MB` (Beats `0.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximize-sum-of-squares-of-digits/solutions/8572833/kotlin-on-22ms-o1-by-alexeyminkin-q04v)
 */
class SolutionImpl1 : Solution {
    override fun maxSumOfSquares(num: Int, sum: Int): String {
        if (num * 9 < sum) return ""
        var sum = sum
        return String(CharArray(num) {
            val minus = Math.min(sum, 9)
            sum -= minus
            '0' + minus
        })
    }
}