package problems.p0944

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.24 MB` (Beats `75.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        for (i in 0 until strs[0].length) {
            var prevChar = strs[0][i]
            for (j in 1 until strs.size) {
                val curChar = strs[j][i]
                if (curChar < prevChar) {
                    result++
                    break
                }
                prevChar = curChar
            }
        }
        return result
    }
}