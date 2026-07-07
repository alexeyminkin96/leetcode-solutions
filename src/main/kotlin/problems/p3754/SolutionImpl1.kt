package problems.p3754

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.66 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/solutions/8381711/kotlin-ologn-0ms-o1-by-alexeyminkin-dxvw)
 */
class SolutionImpl1 : Solution {
    override fun sumAndMultiply(n: Int): Long {
        var n = n
        var base = 1
        var sum = 0
        var x = 0
        while (n != 0) {
            val rem = n % 10
            n /= 10
            x += rem * base
            sum += rem
            if (rem != 0) base *= 10
        }
        return x.toLong() * sum
    }
}