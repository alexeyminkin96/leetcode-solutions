package problems.p3370

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.88 MB` (Beats `57.14%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use `takeHighestOneBit()` to get the most significant power of two ≤ n.
 * - Left shift it once to get the next power of two.
 * - Subtract 1 to make all lower bits set (form 2^k - 1).
 *
 * **Techniques:**
 * - Bit manipulation
 */
class SolutionImpl2 : Solution {
    override fun smallestNumber(n: Int): Int {
        return n.takeHighestOneBit().shl(1) - 1
    }
}