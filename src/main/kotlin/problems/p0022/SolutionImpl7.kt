package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `48.74%` of Kotlin submissions)
 * - Memory: `42.41 MB` (Beats `95.17%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 *
 * **Approach:**
 * - Iterative DFS using compact integer encoding.
 * - Each state (left, right, bits) stored in a single `Int`.
 * - Build final strings by decoding bit patterns into parentheses.
 *
 * **Techniques:**
 * - Bitmask encoding
 * - Manual stack simulation
 * - No recursion
 * - Primitive arrays only
 *
 * **Notes:**
 * - Fastest local variant.
 * - ~50% time lost to GC moving strings.
 * - With Epsilon GC runtime ~2× faster.
 */
class SolutionImpl7 {

    fun generateParenthesis(n: Int): Array<String> {
        var count = 1
        for (i in 0 until n)
            count = count * (2 * (2 * i + 1)) / (i + 2)

        val stack = IntArray(count)
        var stackIndex = 0
        var resultIndex = count - 1

        var previous: Int
        var left: Int
        var right: Int
        var bits: Int
        var isPreviousChanged: Boolean
        val charsBuf = CharArray(2 * n)
        val brackets = charArrayOf('(', ')')

        while (stackIndex >= 0) {
            previous = stack[stackIndex]

            left = previous ushr 24
            right = (previous ushr 16) and 0xFF
            bits = previous and 0xFFFF

            if (left == n && right == n) {
                stack[resultIndex--] = previous
                stackIndex--
                continue
            }

            isPreviousChanged = false
            if (left < n) {
                isPreviousChanged = true
                stack[stackIndex] = ((left + 1) shl 24) or (right shl 16) or ((bits shl 1) and 0xFFFF)
            }
            if (right < left) {
                if (isPreviousChanged)
                    stackIndex++
                stack[stackIndex] = (left shl 24) or ((right + 1) shl 16) or (((bits shl 1) or 1) and 0xFFFF)
            }
        }

        return Array(count) {
            bits = stack[it]
            for (i in charsBuf.size - 1 downTo 0) {
                charsBuf[i] = brackets[bits and 1]
                bits = bits ushr 1
            }
            String(charsBuf)
        }
    }
}