package problems.p0717

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100%` of Kotlin submissions)
 * - Memory: `43.24 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Count trailing 1s before last 0
 *
 * **Techniques:**
 * - Reverse scan
 *
 * **Notes:**
 * - Worst case O(n), average case very few steps
 */
class SolutionImpl2 : Solution {
    override fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = bits.size - 1
        var ones = 0
        while (--i >= 0 && bits[i] == 1)
            ones++
        return ones % 2 == 0
    }
}