package problems.p2515

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.05 MB` (Beats `40.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/submissions/1979015139)
 */
class SolutionImpl1 : Solution {
    override fun closestTarget(words: Array<String>, target: String, start: Int): Int {
        val n = words.size
        for (i in 0..n.shr(1))
            if (words[(start - i + n) % n] == target || words[(start + i) % n] == target) return i
        return -1
    }
}
