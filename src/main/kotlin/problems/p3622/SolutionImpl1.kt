package problems.p3622

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.99 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/solutions/8475752/kotlin-ologn-0ms-o1-by-alexeyminkin-8j6u)
 */
class SolutionImpl1 : Solution {
    override fun checkDivisibility(n: Int): Boolean {
        var sum = 0
        var prod = 1
        var varN = n
        while (varN != 0) {
            val dig = varN % 10
            sum += dig
            prod *= dig
            varN /= 10
        }
        return n % (sum + prod) == 0
    }
}
