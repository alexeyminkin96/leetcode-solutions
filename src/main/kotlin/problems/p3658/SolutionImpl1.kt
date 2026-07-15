package problems.p3658

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.20 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/gcd-of-odd-and-even-sums/solutions/8398469/kotlin-o1-0ms-o1-by-alexeyminkin-kqvb)
 */
class SolutionImpl1 : Solution {
    override fun gcdOfOddEvenSums(n: Int): Int {
//        oddSum = (1 + n * 2 - 1) * n / 2 = (n * 2) * n / 2 = n * n
//        evenSum = (2 + n * 2) * n / 2 = (1 + n) * n
//        gcd(oddSum, evenSum) = n
        return n
    }
}