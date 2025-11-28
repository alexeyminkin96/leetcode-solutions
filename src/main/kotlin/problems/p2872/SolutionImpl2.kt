package problems.p2872

/**
 * **LeetCode Performance:**
 * - Runtime: `29 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `83.49 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val childs = Array(n) { mutableListOf<Int>() }

        for (i in 0 until edges.size) {
            childs[edges[i][0]].add(edges[i][1])
            childs[edges[i][1]].add(edges[i][0])
        }

        var count = 0

        fun findRem(parent: Int, current: Int): Int {
            var rem = values[current]

            for (i in 0 until childs[current].size) {
                if (childs[current][i] != parent)
                    rem += findRem(current, childs[current][i])
            }

            rem %= k
            if (rem == 0) count++
            return rem
        }

        findRem(-1, 0)

        return count
    }
}