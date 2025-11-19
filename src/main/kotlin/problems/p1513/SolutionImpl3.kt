package problems.p1513

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `98.06%` of Kotlin submissions)
 * - Memory: `45.13 MB` (Beats `54.52%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Convert char to 0/1 flag
 * - Multiply running count by flag
 * - Add to global sum
 *
 * **Techniques:**
 * - Byte arithmetic
 */
class SolutionImpl3 : Solution {
    override fun numSub(s: String): Int {
        var gCount = 0L
        var onesCount = 0L
        for (byte in s.toByteArray()) {
            onesCount = (onesCount + 1) * (byte - 48)
            gCount += onesCount
        }
        return (gCount % 1_000_000_007).toInt()
    }
}