package problems.p2751

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `18 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `87.62 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/robot-collisions/solutions/7741538/kotlin-onlogn-18ms-on-primitives-only-bi-rgbq)
 */
class SolutionImpl2 : Solution {
    override fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): IntArray {
        val directions = directions.toCharArray()
        val bits = 30
        val mask = (1L shl bits) - 1
        val n = positions.size
        val robots = LongArray(n)
        for (i in 0 until n)
            robots[i] = (positions[i].toLong() shl bits) or i.toLong()
        Arrays.sort(robots)
        var remain = n
        val stack = LongArray(n)
        var stackI = 0
        var robotsI = 0
        while (robotsI < n) {
            val rI = (robots[robotsI] and mask).toInt()
            if (directions[rI] == 'R') stack[stackI++] = robots[robotsI++]
            else {
                if (stackI == 0) robotsI++
                else {
                    val lI = (stack[stackI - 1] and mask).toInt()
                    val diff = --healths[lI] - --healths[rI]
                    if (diff >= 0) {
                        healths[rI] = 0
                        robotsI++
                        remain--
                    }
                    if (diff <= 0) {
                        healths[lI] = 0
                        stackI--
                        remain--
                    }
                }
            }
        }
        val result = IntArray(remain)
        var h = 0
        for (i in 0 until n)
            if (healths[i] > 0) result[h++] = healths[i]
        return result
    }
}
