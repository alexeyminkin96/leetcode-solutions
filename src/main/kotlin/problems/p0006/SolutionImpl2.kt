package problems.p0006

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.28 MB` (Beats `79.06%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Use iterative filling by rows.
 * - Alternate step size to move through zigzag positions.
 * - Avoid nested loops for better cache efficiency.
 *
 * **Techniques:**
 * - Loop optimization
 * - CharArray construction
 * - Arithmetic indexing
 */
class SolutionImpl2 : Solution {
    override fun convert(s: String, numRows: Int): String {
        val newS = CharArray(s.length)
        val maxGap = if (numRows == 1) 1 else 2 * numRows - 2
        var arrayIndex = 0

        var currentRow = 0
        var stringIndex = 0
        var nextGap = maxGap

        while (arrayIndex < newS.size) {
            if (stringIndex >= s.length) {
                stringIndex = ++currentRow
                nextGap = 2 * currentRow
            }

            newS[arrayIndex++] = s[stringIndex]
            nextGap = if (maxGap - nextGap == 0) maxGap else maxGap - nextGap
            stringIndex += nextGap
        }

        return String(newS)
    }
}