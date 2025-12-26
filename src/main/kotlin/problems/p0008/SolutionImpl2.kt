package problems.p0008

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `95.31%` of Kotlin submissions)
 * - Memory: `42.66 MB` (Beats `77.81%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun myAtoi(s: String): Int {
        var result = 0L
        val charArray = s.toCharArray()
        var sign = 1
        var i = 0
        var step = 0
        while (i < charArray.size) {
            when (step) {
                0 -> if (charArray[i] == ' ') i++ else step++
                1 -> {
                    if (charArray[i] == '+' || charArray[i] == '-') sign = 44 - charArray[i++].code
                    step++
                }

                2 -> {
                    val digit = charArray[i++].code - 48
                    if (digit < 0 || digit > 9) break
                    result = result * 10 + sign * digit
                    if (result < Int.MIN_VALUE) return Int.MIN_VALUE
                    if (result > Int.MAX_VALUE) return Int.MAX_VALUE
                }
            }
        }
        return result.toInt()
    }
}
