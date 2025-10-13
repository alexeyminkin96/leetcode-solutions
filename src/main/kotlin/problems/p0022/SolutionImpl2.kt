package problems.p0022

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `32.35%` of Kotlin submissions)
 * - Memory: `45.14 MB` (Beats `42.23%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(Cₙ)` — number of valid combinations (Catalan number)
 * - Space: `O(Cₙ)` — all generated combinations stored in memory
 */
class SolutionImpl2 : Solution {

    override fun generateParenthesis(n: Int): List<String> {
        return addNextBracket("", n, n)
    }

    private fun addNextBracket(previous: String, left: Int, right: Int): List<String> {
        if (left == 0 && right == 0) return listOf(previous)
        val list = mutableListOf<String>()

        if (right > left)
            list.addAll(addNextBracket("$previous)", left, right - 1))
        if (left > 0)
            list.addAll(addNextBracket("$previous(", left - 1, right))

        return list
    }
}