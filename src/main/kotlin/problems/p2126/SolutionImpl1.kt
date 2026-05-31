package problems.p2126

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `34 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/destroying-asteroids/solutions/8305018/kotlin-onlogn-34ms-o1-by-alexeyminkin-57yp)
 */
class SolutionImpl1 : Solution {
    override fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        var m = mass.toLong()
        Arrays.sort(asteroids)
        for (a in asteroids)
            if (a <= m) m += a else return false
        return true
    }
}