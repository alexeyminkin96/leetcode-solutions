package problems.p0005

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `93.70%` of Kotlin submissions)
 * - Memory: `42.51 MB` (Beats `69.89%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun longestPalindrome(s: String): String {
        val chars = s.toCharArray()
        var globalL = 0
        var length = 1
        for (i in 0 until chars.size) {
            for (p in 0..1) {
                var l = i - p
                var r = i + 1
                while (l >= 0 && r < chars.size && chars[l] == chars[r]) {
                    l--
                    r++
                }
                if (--r - ++l + 1 > length) {
                    globalL = l
                    length = r - l + 1
                }
            }
        }
        return String(chars, globalL, length)
    }
}
