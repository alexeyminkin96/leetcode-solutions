package problems.p3536

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.51 MB` (Beats `91.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-product-of-two-digits/solutions/8424157/kotlin-ologn-0ms-o1-by-alexeyminkin-qvct)
 */
class SolutionImpl1 : Solution {
    override fun maxProduct(n: Int): Int {
        var n = n
        var max = 0
        var prev = 0
        while (n > 0) {
            val digit = n % 10
            if (digit > max) {
                prev = max
                max = digit
            } else if (digit > prev) prev = digit
            n /= 10
        }
        return max * prev
    }
}