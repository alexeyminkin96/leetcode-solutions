package problems.p3963

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.00 MB` (Beats `22.22%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m + n)`
 * - Space: `O(m + n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/create-grid-with-exactly-one-path/solutions/8591005/kotlin-omn-2ms-omn-by-alexeyminkin-6m4k)
 */
class SolutionImpl1 : Solution {
    override fun createGrid(m: Int, n: Int): Array<String> {
        val sb = CharArray(n) { '#' }
        sb[n - 1] = '.'
        val row = String(sb)
        val res = Array(m) { row }
        Arrays.fill(sb, '.')
        res[0] = String(sb)
        return res
    }
}