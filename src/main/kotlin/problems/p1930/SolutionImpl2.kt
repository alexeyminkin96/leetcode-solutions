package problems.p1930

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100%`)
 * - Memory: `45.92 MB` (Beats `100%`)
 *
 * **Complexity:**
 * - Time: `O(k*n)` (real `O(27*n)`)
 * - Space: `O(k)` (real `O(3*26)`)
 *
 * **Approach:**
 * - Precompute first/last index for each char
 * - For each position check if it is valid center
 * - Use bitmask to mark found palindromes
 *
 * **Techniques:**
 * - Bitmask
 * - Precompute borders
 */
class SolutionImpl2 : Solution {
    override fun countPalindromicSubsequence(s: String): Int {
        val firstCharCode = 97
        val symbolCount = 26
        val sqSymbolCount = symbolCount * symbolCount

        val firsts = IntArray(symbolCount) { s.length }
        val lasts = IntArray(symbolCount)

        val charArray = s.toCharArray()
        for (i in 0 until charArray.size) {
            val charIndex = charArray[i].code - firstCharCode
            if (i < firsts[charIndex]) firsts[charIndex] = i
            lasts[charIndex] = i
        }

        val centerToEdge = IntArray(symbolCount)
        var count = 0
        for (i in 0 until charArray.size) {
            val center = charArray[i].code - firstCharCode
            for (edge in 0 until symbolCount) {
                if (centerToEdge[center] and (1 shl edge) == 0 && i > firsts[edge] && i < lasts[edge]) {
                    centerToEdge[center] = centerToEdge[center] or (1 shl edge)
                    count++
                    if (count == sqSymbolCount) return count
                }
            }
        }

        return count
    }
}