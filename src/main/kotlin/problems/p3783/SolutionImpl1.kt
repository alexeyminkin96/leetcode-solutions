package problems.p3783

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.73 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/mirror-distance-of-an-integer/solutions/7975402/kotlin-ologn-1ms-o1-by-alexeyminkin-25jq)
 */
class SolutionImpl1 : Solution {
    override fun mirrorDistance(n: Int): Int {
        var num = n
        var rev = 0
        while (num != 0) {
            val buf = num / 10
            rev = rev * 10 + num - buf * 10
            num = buf
        }
        return Math.abs(n - rev)
    }
}