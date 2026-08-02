package problems.p0877

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.71 MB` (Beats `89.47%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game/solutions/8436471/kotlin-o1-0ms-o1-by-alexeyminkin-kjfc)
 */
class SolutionImpl1 : Solution {
    override fun stoneGame(piles: IntArray): Boolean {
        // Alisa chooses either the even piles or the odd ones, depending on which set has the greater sum.
        // The sums cannot be equal, since the total number of stones is odd.
        return true
    }
}