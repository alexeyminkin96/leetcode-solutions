package problems.p0066

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.18 MB` (Beats `81.60%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/last-day-where-you-can-still-cross/solutions/7452584/kotlin-orowcol-10ms-orowcol-continuous-r-x46u)
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