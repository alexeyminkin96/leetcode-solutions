package problems.p0657

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.08 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/robot-return-to-origin/solutions/7783861/kotlin-on-4ms-o1-by-alexeyminkin-lklj)
 */
class SolutionImpl1 : Solution {
    override fun judgeCircle(moves: String): Boolean {
        if (moves.length and 1 == 1) return false
        val moves = moves.toCharArray()
        var y = 0
        var x = 0
        for (i in 0 until moves.size) {
            when (moves[i]) {
                'U' -> y++
                'D' -> y--
                'L' -> x--
                'R' -> x++
            }
        }
        return y == 0 && x == 0
    }
}