package problems.p3454

/**
 * **LeetCode Performance:**
 * - Runtime: `263 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `87.25 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {
    override fun separateSquares(squares: Array<IntArray>): Double {
        val segments = squares
            .flatMap { listOf(it[0], it[0] + it[2]) }
            .distinct()
            .sorted()
            .toIntArray()
        val segTree = SegmentTree(segments)
        var v = 0L
        var prevY = 0
        var prevSum = 0L

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
                v = segTree.add(dot.xLeft, dot.xRight, dot.v).toLong()
                prevY = dot.y
                prevSum = dot.sum
            }
            .distinctBy { it.y }

        var ind = sortedDots
            .binarySearchBy(prevSum / 2) { it.sum }

        return if (ind >= 0) {
            while (sortedDots[ind - 1].sum == sortedDots[ind].sum) ind--
            sortedDots[ind].y.toDouble()
        } else {
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

    class SegmentTree(
        private val segments: IntArray
    ) {
        private val last = segments.size - 1
        private val covers = IntArray(4 * last)
        private val lengths = IntArray(4 * last)

        fun add(left: Int, right: Int, v: Int): Int {
            val xLeft = segments.binarySearch(left)
            val xRight = segments.binarySearch(right)
            updateCover(1, 0, last, xLeft, xRight, v)
            return lengths[1]
        }

        private fun updateCover(node: Int, sLeft: Int, sRight: Int, xLeft: Int, xRight: Int, v: Int) {
            if (sRight <= xLeft || sLeft >= xRight) return
            if (sLeft >= xLeft && sRight <= xRight) {
                covers[node] += v
            } else {
                val mid = (sLeft + sRight) / 2
                updateCover(node * 2, sLeft, mid, xLeft, xRight, v)
                updateCover(node * 2 + 1, mid, sRight, xLeft, xRight, v)
            }
            lengths[node] = when {
                covers[node] > 0 -> segments[sRight] - segments[sLeft]
                sRight - sLeft == 1 -> 0
                else -> lengths[node * 2] + lengths[node * 2 + 1]
            }
        }
    }
}
