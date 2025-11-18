package problems.p0717

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `43.48 MB` (Beats `44.44%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Move index by 1 or 2 based on bit value
 *
 * **Techniques:**
 * - Simple loop
 */
class SolutionImpl1 : Solution {
    override fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = 0
        while (i < bits.size - 1)
            i += bits[i] + 1
        return i == bits.size - 1
    }
}