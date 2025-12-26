package problems.p0008

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `95.31%` of Kotlin submissions)
 * - Memory: `42.43 MB` (Beats `85.31%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl3 : Solution {
    private val div = Int.MAX_VALUE / 10
    override fun myAtoi(s: String): Int {
        var result = 0
        val charArray = s.toCharArray()
        var isNegative = 0
        var i = 0
        while (i < charArray.size && charArray[i] == ' ') i++
        if (i < charArray.size && (charArray[i] == '+' || charArray[i] == '-')) isNegative =
            (charArray[i++].code - 43) / 2
        while (i < charArray.size) {
            val digit = charArray[i++].code - 48
            if (digit < 0 || digit > 9) break
            if (result > div || (result == div && digit >= 7 + isNegative))
                return (Int.MAX_VALUE + isNegative)
            result = result * 10 + digit
        }
        if (isNegative == 1) return -result
        return result
    }
}
