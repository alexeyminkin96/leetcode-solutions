package problems.p0017

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.71 MB` (Beats `99.73%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(4^n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/7455098/kotlin-o4n-0ms-on-not-recursion-by-alexe-3x8x)
 */
class SolutionImpl1 : Solution {
    private val firstCharButton = charArrayOf('a', 'd', 'g', 'j', 'm', 'p', 't', 'w', '{')

    override fun letterCombinations(digits: String): Array<String> {
        val length = digits.length
        val buttons = IntArray(length)
        val chars = CharArray(length)
        var size = 1
        for (i in 0 until length) {
            buttons[i] = digits[i] - '2'
            chars[i] = firstCharButton[buttons[i]]
            size *= firstCharButton[buttons[i] + 1] - firstCharButton[buttons[i]]
        }

        val result = arrayOfNulls<String>(size)

        for (i in 0 until size) {
            var j = 0
            while (chars[j] == firstCharButton[buttons[j] + 1]) {
                chars[j] = firstCharButton[buttons[j]]
                chars[++j]++
            }
            result[i] = String(chars)
            chars[0]++
        }

        return result as Array<String>
    }
}
