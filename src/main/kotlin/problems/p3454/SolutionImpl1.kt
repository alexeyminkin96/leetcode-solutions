package problems.p3454

/**
 * **LeetCode Performance:**
 * - Runtime: `XX ms` (Beats `YY%` of Kotlin submissions)
 * - Memory: `ZZ MB` (Beats `WW%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(?)`
 * - Space: `O(?)`
 */
class SolutionImpl1 : Solution {
    override fun separateSquares(squares: Array<IntArray>): Double {
        var v = 0L
        var prevY = 0
        var prevSum = 0L

        val segments = squares
            .asSequence()
            .flatMap { listOf(it[0], it[0] + it[2]) }
            .distinct()
            .sorted()
            .zipWithNext { l, r -> Segment(l, r - l) }
            .toList()

        val sortedDots = squares
            .flatMap {
                listOf(
                    Dot(it[1], 1, it[0], it[0] + it[2]),
                    Dot(it[1] + it[2], -1, it[0], it[0] + it[2])
                )
            }
            .sortedBy { it.y }
            .onEach { dot ->
                dot.sum = prevSum + ((dot.y - prevY) * v) * 2

                var ind = segments
                    .binarySearchBy(dot.xLeft) { it.left }

                while (ind < segments.size) {
                    val segment = segments[ind++]
                    if (segment.left >= dot.xRight) break
                    if (segment.count == 0) v += segment.length
                    segment.count += dot.v
                    if (segment.count == 0) v -= segment.length
                }

                prevY = dot.y
                prevSum = dot.sum
            }
            .distinctBy { it.y }

        val ind = sortedDots
            .binarySearchBy(prevSum / 2) { it.sum }

        return if (ind >= 0) sortedDots[ind].y.toDouble()
        else {
            val l = sortedDots[-ind - 2]
            val r = sortedDots[-ind - 1]
            (r.y - l.y) * (prevSum / 2 - l.sum).toDouble() / (r.sum - l.sum) + l.y
        }
    }

    data class Dot(
        val y: Int,
        val v: Int,
        val xLeft: Int,
        val xRight: Int,
        var sum: Long = 0
    )

    data class Segment(
        val left: Int,
        val length: Int,
        var count: Int = 0,
    )
}