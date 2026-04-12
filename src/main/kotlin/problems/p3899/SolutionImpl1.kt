package problems.p3899

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.04 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/angles-of-a-triangle/solutions/7892309/kotlin-o1-3ms-o1-by-alexeyminkin-14hp)
 */
class SolutionImpl1 : Solution {
    override fun internalAngles(sides: IntArray): DoubleArray {
        val a = sides[0].toDouble()
        val b = sides[1].toDouble()
        val c = sides[2].toDouble()
        if (a >= b + c || b >= a + c || c >= a + b) return DoubleArray(0)
        val res = DoubleArray(3)
        res[0] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)))
        res[1] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)))
        res[2] = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)))
        Arrays.sort(res)
        return res
    }
}