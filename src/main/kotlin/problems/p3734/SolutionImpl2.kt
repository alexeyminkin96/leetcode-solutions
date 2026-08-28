package problems.p3734

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.47 MB` (Beats `96.90%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*C)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/solutions/8499748/kotlin-onc-2ms-on-primitives-only-by-ale-x5jv)
 */
class SolutionImpl2 : Solution {
    override fun lexPalindromicPermutation(s: String, target: String): String {
        val n = s.length
        val counts = IntArray(26)
        for (c in s) counts[c - 'a']++
        var center = 'a' - 1
        for (i in 0 until 26) {
            if (counts[i] and 1 == 1)
                if (center < 'a') center = 'a' + i else return ""
            counts[i] = counts[i] shr 1
        }
        val res = CharArray(n)
        if (n and 1 == 1) res[n shr 1] = center
        fun fill(charIdx: Int): Boolean {
            if (charIdx == n shr 1) {
                for (i in charIdx until n)
                    if (res[i] != target[i]) return (res[i] > target[i])
                return false
            }
            var charCode = target[charIdx] - 'a'
            if (counts[charCode] > 0) {
                counts[charCode]--
                res[charIdx] = 'a' + charCode
                res[n - 1 - charIdx] = 'a' + charCode
                if (fill(charIdx + 1)) return true
                counts[charCode++]++
            }
            while (charCode < 26 && counts[charCode] == 0) charCode++
            if (charCode == 26) return false
            counts[charCode]--
            res[charIdx] = 'a' + charCode
            res[n - 1 - charIdx] = 'a' + charCode
            var resIdx = charIdx + 1
            for (nextCharCode in 0 until 26)
                for (repeat in 0 until counts[nextCharCode]) {
                    res[resIdx] = 'a' + nextCharCode
                    res[n - 1 - resIdx++] = 'a' + nextCharCode
                }
            return true
        }
        return if (fill(0)) String(res) else ""
    }
}