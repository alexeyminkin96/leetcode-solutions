package problems.p1015

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.26 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-integer-divisible-by-k/solutions/7373247/kotlin-on-2ms-o1-by-alexeyminkin-m7o0)
 */
class SolutionImpl1 : Solution {
    override fun smallestRepunitDivByK(k: Int): Int {
        var n = 0
        for (i in 1..k) {
            n = (10 * n + 1) % k
            if (n == 0) return i
        }
        return -1
    }
}
