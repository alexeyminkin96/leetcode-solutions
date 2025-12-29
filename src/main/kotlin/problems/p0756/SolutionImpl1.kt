package problems.p0756

/**
 * **LeetCode Performance:**
 * - Runtime: `3539 ms` (Beats `-%` of Kotlin submissions)
 * - Memory: `55.19 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m^(n^2))`
 * - Space: `O(m^n)`
 */
class SolutionImpl1 : Solution {
    override fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        fun createRow(str: String, i: Int): List<String> {
            if (i == bottom.length - 1) return listOf(str)
            return allowed
                .filter { it[0] == bottom[i] && it[1] == bottom[i + 1] }
                .flatMap { createRow(str + it[2], i + 1) }
        }
        val rows = createRow("", 0)
        if (rows.isEmpty()) return false
        if (bottom.length == 2) return true
        for (row in rows) {
            if (pyramidTransition(row, allowed)) return true
        }
        return false
    }
}