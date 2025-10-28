package problems.p0013

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `99.64%` of Kotlin submissions)
 * - Memory: `45.60 MB` (Beats `83.14%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Step 1: Iterate over string.
 * - Step 2: Convert char to value.
 * - Step 3: Subtract twice previous if current > previous.
 * - Step 4: Accumulate result.
 *
 * **Techniques:**
 * - HashMap or when-expression for Roman values.
 */
class SolutionImpl1 : Solution {

    override fun romanToInt(s: String): Int {
        var result = 0
        var previousValue = 1000

        s
            .forEach { char ->
                val value = when (char) {
                    'I' -> 1
                    'V' -> 5
                    'X' -> 10
                    'L' -> 50
                    'C' -> 100
                    'D' -> 500
                    'M' -> 1000
                    else -> 0
                }
                if (value > previousValue)
                    result -= previousValue * 2
                result += value
                previousValue = value
            }

        return result
    }
}