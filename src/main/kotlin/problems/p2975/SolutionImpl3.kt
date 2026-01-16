package problems.p2975

/**
 * **LeetCode Performance:**
 * - Runtime: `347 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `116.33 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(h^2 + v^2)`
 * - Space: `O(h^2 + v^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/solutions/7500347/kotlin-oh2-v2-347ms-oh2-v2-by-alexeymink-ifi3)
 */
class SolutionImpl3 : Solution {
    override fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val hLengths = getLengths(m, hFences)
        val vLengths = getLengths(n, vFences)
        val (small, big) = if (hLengths.size > vLengths.size) vLengths to hLengths else hLengths to vLengths
        var result = 0
        for (s in small) if (s > result && big.contains(s)) result = s
        return if (result == 0) -1 else ((result.toLong() * result) % 1_000_000_007).toInt()
    }

    private fun getLengths(last: Int, ar: IntArray): Set<Int> {
        val lengths = HashSet<Int>((ar.size + 2) * (ar.size + 1) / 2)
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