package problems.p2409

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.90 MB` (Beats `44.44%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-days-spent-together/solutions/8587911/kotlin-on-0ms-o1-by-alexeyminkin-0hzb)
 */
class SolutionImpl1 : Solution {
    override fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {
        return Math.max(
            Math.min(getDays(leaveAlice), getDays(leaveBob)) - Math.max(getDays(arriveAlice), getDays(arriveBob)) + 1,
            0
        )
    }

    private fun getDays(mmdd: String): Int {
        return (mmdd[3] - '0') * 10 + (mmdd[4] - '0') + when ((mmdd[0] - '0') * 10 + (mmdd[1] - '0')) {
            1 -> 0
            2 -> 31
            3 -> 59
            4 -> 90
            5 -> 120
            6 -> 151
            7 -> 181
            8 -> 212
            9 -> 243
            10 -> 273
            11 -> 304
            else -> 334
        }
    }
}