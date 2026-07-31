package problems.p3016

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.08 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/solutions/8432211/kotlin-on-5ms-o1-by-alexeyminkin-lpmj)
 */
class SolutionImpl1 : Solution {
    override fun minimumPushes(word: String): Int {
        val counts = IntArray(27)
        for (c in word.toCharArray()) counts[c - 'a']++
        Arrays.sort(counts)
        var res = 0
        var i = 0
        while (counts[26 - i] != 0)
            res += counts[26 - i] * (i++ / 8 + 1)
        return res
    }
}