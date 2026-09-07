package problems.p0940

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.61 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/distinct-subsequences-ii/solutions/8507071/kotlin-on-2ms-o1-by-alexeyminkin-hxnw)
 */
class SolutionImpl1 : Solution {
    override fun distinctSubseqII(s: String): Int {
        val counts = IntArray(26)
        var sum = 0L
        for (c in s.toCharArray()) {
            val oldCount = counts[c - 'a']
            counts[c - 'a'] = sum.toInt() + 1
            sum = ((sum shl 1) + 1 - oldCount + 1_000_000_007) % 1_000_000_007
        }
        return sum.toInt()
    }
}