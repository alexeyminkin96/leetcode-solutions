package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `39.92%` of Kotlin submissions)
 * - Memory: `46.58 MB` (Beats `11.97%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 */
class SolutionImpl3 : Solution {

    override fun generateParenthesis(n: Int): List<String> {
        return addNextBracket(CharArray(2 * n), n, n)
    }

    private fun addNextBracket(previous: CharArray, left: Int, right: Int): List<String> {
        if (right == 0 && left == 0) return listOf(String(previous))
        val result = mutableListOf<String>()

        if (left < right)
            result.addAll(addNextBracket(previous.also { it[left + right - 1] = '(' }, left, right - 1))
        if (left > 0)
            result.addAll(addNextBracket(previous.copyOf().also { it[left + right - 1] = ')' }, left - 1, right))

        return result
    }
}