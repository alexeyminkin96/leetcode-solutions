package problems.p2029

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `64.40 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/stone-game-ix/solutions/8464260/kotlin-on-3ms-o1-by-alexeyminkin-d7bq)
 */
class SolutionImpl1 : Solution {
    override fun stoneGameIX(stones: IntArray): Boolean {
        val counts = IntArray(3)
        for (stone in stones) counts[stone % 3]++
        return if (counts[1] * counts[2] != 0)
            (counts[0] and 1) == 0 || Math.abs(counts[1] - counts[2]) >= 3
        else
            (counts[0] and 1) == 1 && counts[1] + counts[2] >= 3
    }
}