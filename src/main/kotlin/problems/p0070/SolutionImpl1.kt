package problems.p0070

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.71 MB` (Beats `86.99%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/climbing-stairs/solutions/7388136/kotlin-on-0ms-o1-by-alexeyminkin-y7k6)
 */
class SolutionImpl1 : Solution {
    override fun climbStairs(n: Int): Int {
        var f1 = 0
        var f2 = 1
        for (i in 1..n) {
            f2 += f1
            f1 = f2 - f1
        }
        return f2
    }
}