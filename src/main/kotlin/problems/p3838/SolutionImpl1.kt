package problems.p3838

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.92 MB` (Beats `78.06%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/weighted-word-mapping/solutions/8367566/kotlin-on-2ms-o1-by-alexeyminkin-kf9a)
 */
class SolutionImpl1 : Solution {
    override fun mapWordWeights(words: Array<String>, weights: IntArray): String {
        return String(CharArray(words.size) {
            var sum = 0
            for (c in words[it])
                sum += weights[c - 'a']
            ('z'.code - sum % 26).toChar()
        })
    }
}