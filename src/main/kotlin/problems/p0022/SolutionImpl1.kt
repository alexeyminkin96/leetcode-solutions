package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `11 ms` (Beats `24.16%` of Kotlin submissions)
 * - Memory: `46.08 MB` (Beats `21.85%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 */
class SolutionImpl1 : Solution {

    override fun generateParenthesis(n: Int): List<String> {
        return addNextBracket(n, n)
    }

    private fun addNextBracket(left: Int, right: Int): List<String> {
        if (left == 0 && right == 0) return listOf("")
        val list = mutableListOf<String>()

        if (right > left)
            list.addAll(addNextBracket(left, right - 1).map { ")$it" })
        if (left > 0)
            list.addAll(addNextBracket(left - 1, right).map { "($it" })

        return list
    }
}