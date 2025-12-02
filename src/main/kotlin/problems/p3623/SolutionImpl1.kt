package problems.p3623

/**
 * **LeetCode Performance:**
 * - Runtime: `42 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `127.41 MB` (Beats `62.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-number-of-trapezoids-i/solutions/7387098/kotlin-on-42ms-on-by-alexeyminkin-ltq1)
 */
class SolutionImpl1 : Solution {
    override fun countTrapezoids(points: Array<IntArray>): Int {
        val lineToDotCount = HashMap<Int, DotCount>()

        for (i in 0 until points.size) {
            val line = points[i][1]
            val dotCount = lineToDotCount[line]
            if (dotCount == null) lineToDotCount[line] = DotCount()
            else dotCount.value++
        }

        var trapezoidCount = 0L
        var globalIntervalCount = 0L

        for (value in lineToDotCount.values) {
            val lineDotCount = (value.value - 1).toLong()
            val lineIntervalCount = lineDotCount * (lineDotCount + 1) / 2
            trapezoidCount += lineIntervalCount * globalIntervalCount
            globalIntervalCount += lineIntervalCount
        }

        return (trapezoidCount % 1_000_000_007).toInt()
    }

    private data class DotCount(
        var value: Int = 1
    )
}
