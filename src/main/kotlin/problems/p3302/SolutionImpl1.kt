package problems.p3302

/**
 * **LeetCode Performance:**
 * - Runtime: `15 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `84.09 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m)`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/solutions/8448570/kotlin-onm-15ms-om-primitives-only-by-al-8yw9)
 */
class SolutionImpl1 : Solution {
    override fun validSequence(word1: String, word2: String): IntArray {
        val n = word1.length
        val m = word2.length
        val word1 = word1.toCharArray()
        val word2 = word2.toCharArray()
        val last = IntArray(m + 1)
        last[m] = 1_000_000
        var w1Idx = n - 1
        for (i in m - 1 downTo 0) {
            while (w1Idx >= 0 && word1[w1Idx] != word2[i]) w1Idx--
            last[i] = w1Idx--
        }
        val res = IntArray(m)
        var used = false
        var w2Idx = 0
        for (i in 0 until n) {
            if (word1[i] == word2[w2Idx] || !used && (i < last[w2Idx + 1])) {
                res[w2Idx] = i
                used = used || word1[i] != word2[w2Idx]
                w2Idx++
            }
            if (w2Idx == m) return res
        }
        return IntArray(0)
    }
}