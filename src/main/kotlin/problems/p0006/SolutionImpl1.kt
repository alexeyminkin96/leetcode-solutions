package problems.p0006

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `94.59%` of Kotlin submissions)
 * - Memory: `46.94 MB` (Beats `54.12%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Compute the main zigzag cycle length.
 * - For each row, compute step size alternately.
 * - Append chars following the gap pattern.
 *
 * **Techniques:**
 * - String traversal
 * - Index arithmetic
 */
class SolutionImpl1 : Solution {
    override fun convert(s: String, numRows: Int): String {
        val newS = CharArray(s.length)
        val maxGap = if (numRows == 1) 1 else 2 * numRows - 2
        var arrayIndex = 0

        for (row in 0 until numRows) {
            var stringIndex = row
            var nextGap = 2 * row
            while (stringIndex < s.length) {
                newS[arrayIndex++] = s[stringIndex]
                nextGap = if (maxGap - nextGap == 0) maxGap else maxGap - nextGap
                stringIndex += nextGap
            }
        }

        return String(newS)
    }
}