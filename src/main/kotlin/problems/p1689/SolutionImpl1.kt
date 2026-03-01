package problems.p1689

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.71 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/solutions/7617056/kotlin-on-4ms-on-by-alexeyminkin-iue7)
 */
class SolutionImpl1 : Solution {
    private val zero = 48.toByte()
    override fun minPartitions(n: String): Int {
        var max = zero
        for (c in n.toByteArray())
            if (c > max) max = c
        return max - zero
    }
}
