package problems.p0836

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.28 MB` (Beats `87.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rectangle-overlap/solutions/8521543/kotlin-o1-0ms-o1-by-alexeyminkin-iqxg)
 */
class SolutionImpl1 : Solution {
    override fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        return rec1[3] > rec2[1] && rec1[1] < rec2[3] && rec1[2] > rec2[0] && rec1[0] < rec2[2]
    }
}