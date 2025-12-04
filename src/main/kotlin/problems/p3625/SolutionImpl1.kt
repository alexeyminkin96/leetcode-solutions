package problems.p3625


/**
 * **LeetCode Performance:**
 * - Runtime: `582 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `200.59 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n^2)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-number-of-trapezoids-ii/solutions/7392175/kotlin-on2-582ms-on2-by-alexeyminkin-ltwb)
 */
class SolutionImpl1 : Solution {
    override fun countTrapezoids(points: Array<IntArray>): Int {
        val globalKToQToDotCount = HashMap<Div, HashMap<Div, DotCount>>()
        val midToKToDotCount = HashMap<Dot, HashMap<Div, DotCount>>()
        for (i in 0 until points.size - 1) {
            val localKToQToDotCount = HashMap<Div, HashMap<Div, DotCount>>()
            for (j in i + 1 until points.size) {
                val x1 = points[i][0]
                val y1 = points[i][1]
                val x2 = points[j][0]
                val y2 = points[j][1]

                val xDiff = if (x1 > x2) x1 - x2 else x2 - x1
                val yDiff = if (x1 > x2) y1 - y2 else y2 - y1

                val k = createK(xDiff, yDiff)
                val q = createQ(xDiff, yDiff, x1, y1)
                val mid = Dot(x1 + x2, y1 + y2)

                addDot(k, q, localKToQToDotCount)
                addMidDot(k, mid, midToKToDotCount)
            }
            addLocalToGlobal(localKToQToDotCount, globalKToQToDotCount)
        }

        val globalTrapezoidCount = calculateTrapezoids(globalKToQToDotCount)
        val parallelogramCount = calculateParallelograms(midToKToDotCount)

        return globalTrapezoidCount - parallelogramCount
    }

    private fun addLocalToGlobal(
        localKToQToDotCount: HashMap<Div, HashMap<Div, DotCount>>,
        globalKToQToDotCount: HashMap<Div, HashMap<Div, DotCount>>
    ) {
        for ((k, qToDotCount) in localKToQToDotCount.entries) {
            val globalQToDotCount = globalKToQToDotCount[k]
            if (globalQToDotCount == null) {
                globalKToQToDotCount[k] = qToDotCount
            } else {
                for ((q, dotCount) in qToDotCount.entries) {
                    globalQToDotCount.putIfAbsent(q, dotCount)
                }
            }
        }
    }

    private fun addDot(k: Div, q: Div, localKToQToDotCount: HashMap<Div, HashMap<Div, DotCount>>) {
        val qToDotCount = localKToQToDotCount[k]
        if (qToDotCount == null) {
            val newQToDotCount = HashMap<Div, DotCount>()
            newQToDotCount[q] = DotCount(2)
            localKToQToDotCount[k] = newQToDotCount
        } else {
            val dotCount = qToDotCount[q]
            if (dotCount == null) {
                qToDotCount[q] = DotCount(2)
            } else {
                dotCount.value++
            }
        }
    }

    private fun addMidDot(k: Div, mid: Dot, midToKToDotCount: HashMap<Dot, HashMap<Div, DotCount>>) {
        val kToDotCount = midToKToDotCount[mid]
        if (kToDotCount == null) {
            val newKToDotCount = HashMap<Div, DotCount>()
            newKToDotCount[k] = DotCount(1)
            midToKToDotCount[mid] = newKToDotCount
        } else {
            val dotCount = kToDotCount[k]
            if (dotCount == null) {
                kToDotCount[k] = DotCount(1)
            } else {
                dotCount.value++
            }
        }
    }

    private fun calculateTrapezoids(globalKToQToDotCount: HashMap<Div, HashMap<Div, DotCount>>): Int {
        var trapezoidCount = 0
        for (qToDotCount in globalKToQToDotCount.values) {
            var kTrapezoidCount = 0
            var kIntervalCount = 0
            for (dotCount in qToDotCount.values) {
                val lineIntervalCount = dotCount.value * (dotCount.value - 1) / 2
                kTrapezoidCount += kIntervalCount * lineIntervalCount
                kIntervalCount += lineIntervalCount
            }
            trapezoidCount += kTrapezoidCount
        }
        return trapezoidCount
    }

    private fun calculateParallelograms(midToKToDotCount: HashMap<Dot, HashMap<Div, DotCount>>): Int {
        var parallelogramCount = 0
        for (kToDotCount in midToKToDotCount.values) {
            var count = 0
            var minus = 0
            for (dotCount in kToDotCount.values) {
                count += dotCount.value
                minus += dotCount.value * (dotCount.value - 1) / 2
            }
            parallelogramCount += count * (count - 1) / 2 - minus
        }
        return parallelogramCount
    }

    private fun createK(xDiff: Int, yDiff: Int): Div {
        return if (xDiff == 0) {
            Div(0, 0)
        } else {
            val divisor = gcd(xDiff, yDiff)
            Div(yDiff / divisor, xDiff / divisor)
        }
    }

    private fun createQ(xDiff: Int, yDiff: Int, x1: Int, y1: Int): Div {
        return if (xDiff == 0) {
            Div(x1, 0)
        } else {
            val c = y1 * xDiff - x1 * yDiff
            val divisor = gcd(c, xDiff)
            Div(c / divisor, xDiff / divisor)
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        var varA = Math.abs(a)
        var varB = Math.abs(b)
        while (varB != 0) {
            val rem = varA % varB
            varA = varB
            varB = rem
        }
        return varA
    }

    private data class Div(
        val numerator: Int,
        val denominator: Int
    )

    private data class Dot(
        val x: Int,
        val y: Int
    )

    private data class DotCount(
        var value: Int
    )
}
