package problems.p3360

/**
 * **LeetCode Performance**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.76 MB` (Beats `14.29%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: O(1)
 * - Space: O(1)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-removal-game/solutions/8625511/kotlin-o1-0ms-o1-by-alexeyminkin-upeo)
 */
class SolutionImpl2 : Solution {
    override fun canAliceWin(n: Int): Boolean {
        return Math.ceil((1 + Math.sqrt(441.0 - 8 * n)) / 2).toInt() and 1 == 0
    }
}
/*
(a1 + ak) / 2 * k - arithmetic progression sum

(x + 10) / 2 * (11 - x) = n
x^2 - x - 110 + 2n = 0
x = (1 + sqrt(441 - 8n)) / 2

x - min num
*/