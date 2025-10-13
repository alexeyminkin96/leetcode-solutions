package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `48.74%` of Kotlin submissions)
 * - Memory: `42.03 MB` (Beats `98.74%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 *
 * **Notes:**
 * - Avoids recursive calls and excess allocations.
 * - Uses primitive arrays for memory efficiency and speed.
 */
class SolutionImpl5 {

    fun generateParenthesis(n: Int): Array<String?> {
        var count = 1
        for (i in 0 until n)
            count = count * (2 * (2 * i + 1)) / (i + 2)

        val result = Array<String?>(count) { null }
        var resultIndex = 0

        val stack = Array<Frame?>(count) { null }
        var stackIndex = 0
        stack[stackIndex] = (Frame(CharArray(2 * n) { ')' }, 0, 0))

        var previous: Frame
        var left: Int
        var right: Int
        var isPreviousChanged: Boolean

        while (stackIndex >= 0) {
            if (stackIndex + resultIndex > count)
                println(stackIndex + resultIndex)

            previous = stack[stackIndex]!!

            left = previous.left
            right = previous.right

            if (left == n && right == n) {
                result[resultIndex++] = String(previous.chars)
                stackIndex--
                continue
            }
            isPreviousChanged = false
            if (left < n) {
                isPreviousChanged = true
                previous.chars[left + right] = '('
                previous.left = left + 1
            }
            if (right < left) {
                if (isPreviousChanged) {
                    val addedFrame = Frame(previous.chars.copyOf(), left, right + 1)
                    addedFrame.chars[left + right] = ')'
                    stack[++stackIndex] = addedFrame
                } else
                    previous.right = right + 1
            }
        }

        return result
    }

    data class Frame(
        val chars: CharArray,
        var left: Int,
        var right: Int
    )
}