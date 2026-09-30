package problems.p1111

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.78 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solutions/8548301/kotlin-on-1ms-o1-by-alexeyminkin-cpcs)
 */
class SolutionImpl4 : Solution {
    override fun maxDepthAfterSplit(seq: String): IntArray {
        val seq = seq.toCharArray()
        return IntArray(seq.size) { (it + (seq[it] - '(')) and 1 }
    }
}