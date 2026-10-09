package problems.p1541

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.82 MB` (Beats `25.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/solutions/8563850/kotlin-on-7ms-o1-by-alexeyminkin-29eh)
 */
class SolutionImpl1 : Solution {
    override fun minInsertions(s: String): Int {
        var res = 0
        var count = 0
        for (c in s.toCharArray()) {
            if (c == '(') {
                if (count and 1 == 1) {
                    res++
                    count--
                }
                count += 2
            } else {
                if (count == 0) {
                    res++
                    count += 2
                }
                count--
            }
        }
        return res + count
    }
}