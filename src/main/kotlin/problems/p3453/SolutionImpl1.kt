package problems.p3453

/**
 * **LeetCode Performance:**
 * - Runtime: `193 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `113.33 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/separate-squares-i/solutions/7491230/kotlin-onlogn-193ms-on-not-binary-search-rs17)
 */
class SolutionImpl1 : Solution {
    override fun separateSquares(squares: Array<IntArray>): Double {
        val half = squares.sumOf { it[2].toLong() * it[2] }.toDouble() / 2
        var v = 0L
        var prevY = 0
        var prevSum = 0L
        squares
            .flatMap { listOf(Dot(it[1], it[2]), Dot(it[1] + it[2], -it[2])) }
            .sortedBy { it.y }
            .forEach { dot ->
                val sum = prevSum + (dot.y - prevY) * v
                if (sum >= half) {
                    return (dot.y - prevY) * (half - prevSum) / (sum - prevSum) + prevY
                }
                v += dot.v
                prevY = dot.y
                prevSum = sum
            }
        return 0.0
    }

    data class Dot(
        val y: Int,
        val v: Int,
    )
}