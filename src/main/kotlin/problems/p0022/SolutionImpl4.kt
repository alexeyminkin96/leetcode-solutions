package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `23.74%` of Kotlin submissions)
 * - Memory: `45.35 MB` (Beats `34.66%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 *
 * **Notes:**
 * - Avoids recursion, reducing call-stack overhead.
 */
class SolutionImpl4 : Solution {

    override fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        val stack = ArrayDeque<Frame>()
        stack.add(Frame(CharArray(2 * n), 0, 0))

        while (stack.size > 0) {
            val previous = stack.removeLast()

            val left = previous.left
            val right = previous.right

            if (left == n && right == n) {
                result.add(String(previous.chars))
                continue
            }
            if (left < n)
                stack.add(Frame(previous.chars.copyOf().also { it[left + right] = '(' }, left + 1, right))
            if (right < left)
                stack.add(Frame(previous.chars.copyOf().also { it[left + right] = ')' }, left, right + 1))
        }

        return result
    }

    data class Frame(
        val chars: CharArray,
        var left: Int,
        var right: Int
    )
}