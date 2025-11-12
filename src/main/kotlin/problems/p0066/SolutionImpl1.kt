package problems.p0066

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.51 MB` (Beats `67.34%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Go from the end to start.
 * - If digit < 9 → increment and return.
 * - If digit == 9 → set to 0 and continue.
 * - If all 9 → create new array with 1 at start.
 *
 * **Techniques:**
 * - Simple loop
 * - Early return
 */
class SolutionImpl1 : Solution {
    override fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1
                return digits
            } else
                digits[i] = 0
        }
        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }
}