package problems.p3612

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `97.20%` of Kotlin submissions)
 * - Memory: `53.94 MB` (Beats `88.24%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(2 ^ n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/process-string-with-special-operations-i/solutions/8370442/kotlin-o2n-4ms-o1-by-alexeyminkin-evk8)
 */
class SolutionImpl1 : Solution {
    override fun processStr(s: String): String {
        val sb = StringBuilder()
        for (c in s)
            when (c) {
                '*' -> if (sb.length > 0) sb.deleteCharAt(sb.length - 1)
                '#' -> sb.append(sb)
                '%' -> sb.reverse()
                else -> sb.append(c)
            }
        return sb.toString()
    }
}