package problems.p3499

/**
 * **LeetCode Performance:**
 * - Runtime: `32 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.46 MB` (Beats `21.89%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximize-active-section-with-trade-i/solutions/8423543/kotlin-on-32ms-o1-by-alexeyminkin-i2gm)
 */
class SolutionImpl1 : Solution {
    override fun maxActiveSectionsAfterTrade(s: String): Int {
        var prevZeros = -s.length
        var curZeros = 0
        var ones = 0
        var maxBlock = 0
        var prev = '1'
        for (c in s) {
            if (c == '1') {
                ones++
                if (prev != c) {
                    maxBlock = Math.max(maxBlock, prevZeros + curZeros)
                    prevZeros = curZeros
                    curZeros = 0
                }
            } else curZeros++
            prev = c
        }
        return ones + if (prev == '0') Math.max(maxBlock, prevZeros + curZeros) else maxBlock
    }
}