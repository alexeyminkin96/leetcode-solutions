package problems.p0020

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `99.94%` of Kotlin submissions)
 * - Memory: `41.34 MB` (Beats `88.14%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Use CharArray as a stack.
 * - Push opening brackets.
 * - Pop and compare on closing bracket.
 * - Return false on mismatch or underflow.
 * - Return true if stack is empty at the end.
 *
 * **Techniques:**
 * - Stack emulation
 * - CharArray
 * - Bracket matching
 *
 * **Notes:**
 * - Avoids collection overhead.
 * - Compact and efficient implementation.
 */

class SolutionImpl1 : Solution {

    override fun isValid(s: String): Boolean {
        val ar = CharArray(s.length)

        var i = 0
        var leftBracket: Char?

        for (char in s) {
            leftBracket = when (char) {
                ')' -> '('
                ']' -> '['
                '}' -> '{'
                else -> null
            }
            if (leftBracket == null)
                ar[i++] = char
            else if (--i < 0 || leftBracket != ar[i])
                return false
        }

        return i == 0
    }
}