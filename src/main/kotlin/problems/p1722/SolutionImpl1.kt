package problems.p1722

/**
 * **LeetCode Performance:**
 * - Runtime: `40 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `102.14 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/solutions/8030864/kotlin-onm-40ms-on-dsu-only-1-map-by-ale-rdp4)
 */
class SolutionImpl1 : Solution {
    override fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val parents = IntArray(source.size) { it }
        fun findParent(x: Int): Int {
            if (parents[x] != x) parents[x] = findParent(parents[x])
            return parents[x]
        }

        fun union(a: Int, b: Int) {
            parents[findParent(b)] = findParent(a)
        }

        for (i in 0 until allowedSwaps.size) union(allowedSwaps[i][0], allowedSwaps[i][1])
        val counts = HashMap<Long, Count>()
        var temp = Count(1)
        for (i in 0 until source.size) {
            val c = counts.putIfAbsent((findParent(i).toLong() shl 17) or source[i].toLong(), temp)
            if (c != null) ++c.count else temp = Count(1)
        }
        var count = 0
        for (i in 0 until source.size) {
            val c = counts[(findParent(i).toLong() shl 17) or target[i].toLong()]
            if (c == null || --c.count < 0) count++
        }
        return count
    }

    private data class Count(var count: Int = 0)
}