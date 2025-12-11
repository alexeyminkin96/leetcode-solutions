package problems.p3531

/**
 * **LeetCode Performance:**
 * - Runtime: `23 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `117.49 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(b)`(b - building size)
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-covered-buildings/solutions/7406391/kotlin-ob-23ms-on-by-alexeyminkin-c1kz)
 */
class SolutionImpl1 : Solution {
    override fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val yToXMin = IntArray(n + 1) { Int.MAX_VALUE }
        val yToXMax = IntArray(n + 1)
        val xToYMin = IntArray(n + 1) { Int.MAX_VALUE }
        val xToYMax = IntArray(n + 1)

        for (i in 0 until buildings.size) {
            val x = buildings[i][0]
            val y = buildings[i][1]
            if (x < yToXMin[y]) yToXMin[y] = x
            if (x > yToXMax[y]) yToXMax[y] = x
            if (y < xToYMin[x]) xToYMin[x] = y
            if (y > xToYMax[x]) xToYMax[x] = y
        }

        var result = 0

        for (i in 0 until buildings.size) {
            val x = buildings[i][0]
            val y = buildings[i][1]
            if (x > yToXMin[y] && x < yToXMax[y] && y > xToYMin[x] && y < xToYMax[x])
                result++
        }
        return result
    }
}