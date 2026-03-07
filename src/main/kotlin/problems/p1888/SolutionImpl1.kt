package problems.p1888

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solutions/7628847/kotlin-on-0ms-o1-by-alexeyminkin-boek)
 */
class SolutionImpl1 : Solution {
    override fun minFlips(s: String): Int {
        val s = s.toCharArray()
        val n = s.size
        var flips = 0
        for (i in 0 until n)
            flips += (s[i] - '0' + i) and 1
        var minFlips = minOf(flips, n - flips)
        if ((n and 1) == 0) return minFlips
        for (i in 0 until n) {
            val revFlips = flips - (((s[i] - '0') shl 1) - 1)
            flips = n - revFlips
            minFlips = minOf(minFlips, flips, revFlips)
        }
        return minFlips
    }
}
