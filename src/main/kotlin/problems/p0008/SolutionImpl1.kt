package problems.p0008

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `95.31%` of Kotlin submissions)
 * - Memory: `41.94 MB` (Beats `97.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/string-to-integer-atoi/solutions/7440423/kotlin-on-2ms-o1-by-alexeyminkin-93a4)
 */
class SolutionImpl1 : Solution {
    override fun myAtoi(s: String): Int {
        var result = 0L
        val charArray = s.toCharArray()
        var sign = 1
        var i = 0
        while (i < charArray.size && charArray[i] == ' ') i++
        if (i < charArray.size && (charArray[i] == '+' || charArray[i] == '-')) sign = 44 - charArray[i++].code
        while (i < charArray.size) {
            val digit = charArray[i++].code - 48
            if (digit < 0 || digit > 9) break
            result = result * 10 + sign * digit
            if (result < Int.MIN_VALUE) return Int.MIN_VALUE
            if (result > Int.MAX_VALUE) return Int.MAX_VALUE
        }
        return result.toInt()
    }
}
