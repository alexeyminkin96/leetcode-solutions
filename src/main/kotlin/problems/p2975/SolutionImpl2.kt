package problems.p2975

import java.util.TreeSet

/**
 * **LeetCode Performance:**
 * - Runtime: `2126 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `117.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(h^2 log h + v^2 log v)`
 * - Space: `O(h^2 + v^2)`
 */
class SolutionImpl2 : Solution {
    override fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val hLengths = getLengths(m, hFences)
        val vLengths = getLengths(n, vFences)
        val hIt = hLengths.iterator()
        val vIt = vLengths.iterator()
        var hLast = hIt.next()
        var vLast = vIt.next()
        while (true) {
            when {
                hLast > vLast -> hLast = if (hIt.hasNext()) hIt.next() else break
                hLast < vLast -> vLast = if (vIt.hasNext()) vIt.next() else break
                else -> return ((hLast.toLong() * hLast) % 1_000_000_007).toInt()
            }
        }
        return -1
    }

    private fun getLengths(last: Int, ar: IntArray): MutableSet<Int> {
        val lengths = TreeSet<Int>(compareByDescending { it })
        for (i in -1 until ar.size) {
            val l = if (i >= 0) ar[i] else 1
            for (j in i + 1..ar.size) {
                val r = if (j < ar.size) ar[j] else last
                lengths.add(Math.abs(r - l))
            }
        }
        return lengths
    }
}