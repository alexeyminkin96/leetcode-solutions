package problems.p1758

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.47 MB` (Beats `46.15%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/solutions/7626353/kotlin-on-2ms-on-by-alexeyminkin-w8n2)
 */
class SolutionImpl3 : Solution {
    override fun minOperations(s: String): Int {
        val s = s.toByteArray()
        val counts = IntArray(2)
        for (i in 0 until s.size)
            counts[(i and 1) xor (s[i].toInt() and 1)]++
        return Math.min(counts[0], counts[1])
    }
}