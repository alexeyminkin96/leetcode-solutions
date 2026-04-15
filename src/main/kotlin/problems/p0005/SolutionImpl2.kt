package problems.p0005

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.07 MB` (Beats `83.75%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-palindromic-substring/solutions/7926701/kotlin-on2-4ms-o1-from-middle-to-edges-b-htct)
 */
class SolutionImpl2 : Solution {
    override fun longestPalindrome(s: String): String {
        val chars = s.toCharArray()
        var globalL = 0
        var length = 1
        var center = (chars.size - 1) / 2
        var sign = 1
        for (i in 0 until chars.size) {
            sign *= -1
            center += i * sign
            for (p in 0..1) {
                var l = center - p
                var r = center + 1
                while (l >= 0 && r < chars.size && chars[l] == chars[r]) {
                    l--
                    r++
                }
                val currentLength = r - l - 1
                if (currentLength > length) {
                    globalL = l
                    length = currentLength
                }
            }
            if (length / 2 >= center + 1 || length / 2 >= chars.size - center + 1)
                break
        }
        return String(chars, globalL, length)
    }
}
