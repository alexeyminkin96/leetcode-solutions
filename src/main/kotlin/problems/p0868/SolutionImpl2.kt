package problems.p0868

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.90 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/binary-gap/solutions/7599577/kotlin-ologn-0ms-o1-by-alexeyminkin-jqna)
 */
class SolutionImpl2 : Solution {
    override fun binaryGap(n: Int): Int {
        var n = n
        var result = 0
        var count = -32
        while (n != 0) {
            if (n and 1 == 1) {
                result = Math.max(result, count)
                count = 1
            } else count++
            n = n ushr 1
        }
        return result
    }
}