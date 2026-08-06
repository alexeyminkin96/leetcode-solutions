package problems.p3345

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.99 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-divisible-digit-product-i/solutions/8444418/kotlin-ologn-0ms-o1-by-alexeyminkin-mm4l)
 */
class SolutionImpl1 : Solution {
    override fun smallestNumber(n: Int, t: Int): Int {
        var varN = n / 10
        var prod = 1
        while (varN != 0) {
            prod *= varN % 10
            varN /= 10
        }
        var lastDig = n % 10
        while (lastDig != 10 && prod * lastDig % t != 0) lastDig++
        return n - n % 10 + lastDig
    }
}