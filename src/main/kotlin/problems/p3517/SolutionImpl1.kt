package problems.p3517

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `51.10 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/solutions/8427860/kotlin-on-9ms-o1-by-alexeyminkin-q889)
 */
class SolutionImpl1 : Solution {
    override fun smallestPalindrome(s: String): String {
        val n = s.length
        val s = s.toCharArray()
        val charCount = IntArray(26)
        for (i in 0 until (n shr 1)) charCount[s[i] - 'a']++
        val res = CharArray(n)
        res[n shr 1] = s[n shr 1]
        var resIdx = 0
        for (i in 0 until charCount.size)
            while (charCount[i]-- > 0) {
                res[resIdx] = 'a' + i
                res[n - 1 - resIdx++] = 'a' + i
            }
        return String(res)
    }
}