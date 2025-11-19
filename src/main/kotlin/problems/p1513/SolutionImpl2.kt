package problems.p1513

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `90.00%` of Kotlin submissions)
 * - Memory: `44.91 MB` (Beats `70.97%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Count 1-block size
 * - Use formula k*(k+1)/2
 * - Sum all blocks
 *
 * **Techniques:**
 * - Math formula
 */
class SolutionImpl2 : Solution {
    override fun numSub(s: String): Int {
        var gCount = 0L
        var onesCount = 0L
        for (c in s.toCharArray()) {
            if (c == '0') {
                gCount += (1 + onesCount) * onesCount / 2
                onesCount = 0
            } else
                onesCount++
        }
        return ((gCount + (1 + onesCount) * onesCount / 2) % 1_000_000_007).toInt()
    }
}