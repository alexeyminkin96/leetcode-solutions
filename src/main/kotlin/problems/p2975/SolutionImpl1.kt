package problems.p2975

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `866 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `71.17 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(h^2 log h + v^2 log v)`
 * - Space: `O(h^2 + v^2)`
 */
class SolutionImpl1 : Solution {
    override fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val hLengths = getLengths(m, hFences)
        val vLengths = getLengths(n, vFences)
        var h = hLengths.size - 1
        var v = vLengths.size - 1
        while (h >= 0 && v >= 0) {
            when {
                hLengths[h] > vLengths[v] -> h--
                hLengths[h] < vLengths[v] -> v--
                else -> return ((hLengths[h].toLong() * hLengths[h]) % 1_000_000_007).toInt()
            }
        }
        return -1
    }

    private fun getLengths(last: Int, ar: IntArray): IntArray {
        val lengths = IntArray((ar.size + 2) * (ar.size + 1) / 2)
        var k = 0
        for (i in -1 until ar.size) {
            val l = if (i >= 0) ar[i] else 1
            for (j in i + 1..ar.size) {
                val r = if (j < ar.size) ar[j] else last
                lengths[k++] = Math.abs(r - l)
            }
        }
        Arrays.sort(lengths)
        return lengths
    }
}