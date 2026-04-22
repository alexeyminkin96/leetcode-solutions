package problems.p2452

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.76 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(q * d * n)`
 * - Space: `O(d * n + q)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/words-within-two-edits-of-dictionary/solutions/8048455/kotlin-onqd-2ms-ondq-by-alexeyminkin-klz7)
 */
class SolutionImpl3 : Solution {
    override fun twoEditWords(queries: Array<String>, dictionary: Array<String>): Array<String> {
        val dictionary = Array(dictionary.size) { dictionary[it].toCharArray() }
        val res = arrayOfNulls<String>(queries.size)
        var rI = 0
        query@ for (q in 0 until queries.size) {
            val query = queries[q].toCharArray()
            dict@ for (d in 0 until dictionary.size) {
                val dict = dictionary[d]
                var diffCount = 0
                for (i in 0 until query.size)
                    if (query[i] != dict[i] && ++diffCount > 2) continue@dict
                res[rI++] = queries[q]
                continue@query
            }
        }
        return Arrays.copyOf(res, rI)
    }
}