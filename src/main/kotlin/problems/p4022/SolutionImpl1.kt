package problems.p4022

import kotlin.math.pow

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.46 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log k)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/k-th-digit-in-infinite-string/solutions/8465280/kotlin-ologk-1ms-o1-by-alexeyminkin-zris)
 */
class SolutionImpl1 : Solution {
    override fun kthDigit(k: Long): Int {
        var k = k
        var numCount = 9L
        var digCount = 1
        while (k > numCount * digCount) {
            k -= numCount * digCount
            numCount *= 10
            digCount++
        }
        var num = numCount / 9 + (k - 1) / digCount
        val pos = ((k - 1) % digCount).toInt()
        if (num / 10 and 1 == 1L) num = num + 9 - num % 10 * 2
        val res = (num / 10.0.pow(digCount - pos - 1).toLong()) % 10
        return res.toInt()
    }
}