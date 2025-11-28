package problems.p2872

/**
 * **LeetCode Performance:**
 * - Runtime: `32 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `83.95 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val ar = Array(n) { mutableListOf<Int>() }

        for (i in 0 until edges.size) {
            ar[edges[i][0]].add(edges[i][1])
            ar[edges[i][1]].add(edges[i][0])
        }

        return t(-1, 0, ar, values, k).count
    }

    private fun t(parent: Int, ind: Int, ar: Array<MutableList<Int>>, values: IntArray, k: Int): R {
        var count = 0
        var rem = values[ind]

        for (i in 0 until ar[ind].size) {
            if (ar[ind][i] == parent) continue
            val e = t(ind, ar[ind][i], ar, values, k)
            count += e.count
            rem += e.rem
        }

        val r = rem % k
        if (r == 0) count++
        return R(r, count)
    }

    private data class R(
        val rem: Int,
        val count: Int
    )
}