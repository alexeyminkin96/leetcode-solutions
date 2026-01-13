package problems.p3453

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `XX ms` (Beats `YY%` of Kotlin submissions)
 * - Memory: `ZZ MB` (Beats `WW%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(?)`
 * - Space: `O(?)`
 */
class SolutionImpl2 : Solution {
    companion object {
        private val comparator = compareBy<IntArray> { it[0] }
    }

    override fun separateSquares(squares: Array<IntArray>): Double {
        val dots = Array(squares.size * 2) { IntArray(2) }
        var totalSum = 0L
        for (i in 0 until squares.size) {
            dots[2 * i][0] = squares[i][1]
            dots[2 * i][1] = squares[i][2]
            dots[2 * i + 1][0] = squares[i][1] + squares[i][2]
            dots[2 * i + 1][1] = -squares[i][2]
            totalSum += squares[i][2].toLong() * squares[i][2]
        }
        Arrays.sort(dots, comparator)
        val half = totalSum.toDouble() / 2
        var v = 0L
        var prevY = 0
        var prevSum = 0L
        for (dot in dots) {
            val sum = prevSum + (dot[0] - prevY) * v
            if (sum >= half) {
                return (dot[0] - prevY) * (half - prevSum) / (sum - prevSum) + prevY
            }
            v += dot[1]
            prevY = dot[0]
            prevSum = sum
        }
        return 0.0
    }
}