package problems.p2914

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `51.55 MB` (Beats `20.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/solutions/8616788/kotlin-on-5ms-o1-by-alexeyminkin-ekcp)
 */
class SolutionImpl1 : Solution {
    override fun minChanges(s: String): Int {
        var res = 0
        var prev = 0
        var parity = 0
        for (c in s.toCharArray()) {
            if (c - '0' != prev) {
                res += parity
                prev = 1 - prev
            }
            parity = 1 - parity
        }
        return res
    }
}