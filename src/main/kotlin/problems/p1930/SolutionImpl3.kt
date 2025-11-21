package problems.p1930

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100%`)
 * - Memory: `45.67 MB` (Beats `100%`)
 *
 * **Complexity:**
 * - Time: `O(k*n)` (real `O(27*n)`)
 * - Space: `O(k)` (real `O(2*26)`)
 *
 * **Approach:**
 * - Precompute first/last index for each char
 * - For each outer char use range between first and last
 * - Collect unique centers in bitmask
 * - Add count to result
 *
 * **Techniques:**
 * - Bitmask
 * - Range iteration
 *
 * **Notes:**
 * - Faster on big strings, because it has fast out, when all 26 palindromes was found, for each char
 * - [Full explanation](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/solutions/7365012/kotlin-okn-6ms-ok-by-alexeyminkin-ecm8)
 */

class SolutionImpl3 : Solution {
    override fun countPalindromicSubsequence(s: String): Int {
        val firstCharCode = 97
        val symbolCount = 26

        val firsts = IntArray(symbolCount) { s.length }
        val lasts = IntArray(symbolCount)

        val charArray = s.toCharArray()
        for (i in 0 until charArray.size) {
            val charIndex = charArray[i].code - firstCharCode
            if (i < firsts[charIndex]) firsts[charIndex] = i
            lasts[charIndex] = i
        }

        var count = 0

        for (i in 0 until symbolCount) {
            if (firsts[i] + 1 >= lasts[i]) continue
            var cent = 0
            var localCount = 0
            for (j in firsts[i] + 1 until lasts[i]) {
                if (cent and (1 shl charArray[j].code - firstCharCode) == 0) {
                    cent = cent or (1 shl charArray[j].code - firstCharCode)
                    localCount++
                    if (localCount == symbolCount) break
                }
            }
            count += localCount
        }

        return count
    }
}