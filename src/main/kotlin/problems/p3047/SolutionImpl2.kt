package problems.p3047

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `220 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `68.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        val dots = Array(bottomLeft.size * 2) {
            val i = it / 2
            if (it % 2 == 0)
                Dot(bottomLeft[i][1], 1, bottomLeft[i][0], topRight[i][0], topRight[i][1] - bottomLeft[i][1])
            else
                Dot(topRight[i][1], -1, bottomLeft[i][0], topRight[i][0], topRight[i][1] - bottomLeft[i][1])
        }
        Arrays.sort(dots, compareBy { it.y })
        var max = 0
        val exist = mutableSetOf<Dot>()
        for (dot in dots) {
            if (dot.v < 0) {
                exist.remove(Dot(dot.y - dot.h, 1, dot.xLeft, dot.xRight, dot.h))
                continue
            }
            for (exDot in exist) {
                val bl1x = dot.xLeft
                val bl1y = dot.y
                val tr1x = dot.xRight
                val tr1y = dot.y + dot.h

                val bl2x = exDot.xLeft
                val bl2y = exDot.y
                val tr2x = exDot.xRight
                val tr2y = exDot.y + exDot.h

                val l = maxOf(bl1x, bl2x)
                val r = minOf(tr1x, tr2x)
                val b = maxOf(bl1y, bl2y)
                val t = minOf(tr1y, tr2y)

                val w = maxOf(r - l, 0)
                val h = maxOf(t - b, 0)

                max = maxOf(minOf(w, h), max)
            }
            exist.add(dot)
        }
        return max.toLong() * max
    }

    data class Dot(
        val y: Int,
        val v: Int,
        val xLeft: Int,
        val xRight: Int,
        val h: Int,
    )
}