package problems.p0756

/**
 * **LeetCode Performance:**
 * - Runtime: `138 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.80 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(6^(n^2))`
 * - Space: `O(6^n)`
 */
class SolutionImpl2 : Solution {
    override fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val map = HashMap<String, MutableList<String>>()
        for (i in 0 until allowed.size) {
            map.getOrPut(allowed[i].take(2)) { mutableListOf() }
                .add(allowed[i].takeLast(1))
        }

        return pyramidTransition(bottom, "", map, HashMap())
    }

    private fun pyramidTransition(
        bottom: String,
        nextRow: String,
        map: Map<String, List<String>>,
        cache: MutableMap<String, Boolean>
    ): Boolean {
        if (bottom.length < 2) {
            if (nextRow.length == 1) return true
            return cache.getOrPut(nextRow) { pyramidTransition(nextRow, "", map, cache) }
        }
        val tops = map[bottom.take(2)] ?: return false
        for (top in tops) {
            if (pyramidTransition(bottom.drop(1), nextRow + top, map, cache))
                return true
        }
        return false
    }
}