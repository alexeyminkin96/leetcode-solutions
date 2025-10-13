package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `48.74%` of Kotlin submissions)
 * - Memory: `42.06 MB` (Beats `98.74%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 *
 * **Approach:**
 * - Iterative generation using a custom integer stack.
 * - Encode state (left, right, bits) into a single `Int`.
 * - Convert bit patterns to strings after traversal.
 *
 * **Techniques:**
 * - Bitmask encoding
 * - Manual stack simulation
 * - No recursion
 *
 * **Notes:**
 * - No recursive calls or object allocations.
 * - Works entirely with primitive arrays for maximum performance.
 */
class SolutionImpl6 {

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

        val charsBuf = CharArray(2 * n)

        return Array(count) {
            bits = stack[it]
            for (i in 0 until charsBuf.size)
                charsBuf[i] = if ((bits ushr (charsBuf.size - 1 - i)) and 1 == 0) '(' else ')'
            String(charsBuf)
        }
    }
}