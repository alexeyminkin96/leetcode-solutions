package problems.p3047

/**
 * **LeetCode Performance:**
 * - Runtime: `189 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `68.04 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/solutions/7501515/kotlin-on2-189ms-o1-by-alexeyminkin-vdul)
 */
class SolutionImpl1 : Solution {
    override fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        var max = 0
        for (i in 0 until bottomLeft.size - 1) {
            val bl1 = bottomLeft[i]
            val tr1 = topRight[i]
            for (j in i + 1 until bottomLeft.size) {
                val bl2 = bottomLeft[j]
                val tr2 = topRight[j]

                val l = maxOf(bl1[0], bl2[0])
                val r = minOf(tr1[0], tr2[0])
                val b = maxOf(bl1[1], bl2[1])
                val t = minOf(tr1[1], tr2[1])

                val w = maxOf(r - l, 0)
                val h = maxOf(t - b, 0)

                max = maxOf(minOf(w, h), max)
            }
        }
        return max.toLong() * max
    }
}