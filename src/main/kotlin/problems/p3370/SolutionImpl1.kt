package problems.p3370

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.84 MB` (Beats `57.14%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Start from 1 and repeatedly left shift until value > n.
 * - Subtract 1 to fill all lower bits with 1s.
 *
 * **Techniques:**
 * - Bit manipulation
 */
class SolutionImpl1 : Solution {
    override fun smallestNumber(n: Int): Int {
        var powerOfTwo = 1
        while (powerOfTwo <= n)
            powerOfTwo = powerOfTwo shl 1
        return powerOfTwo - 1
    }
}