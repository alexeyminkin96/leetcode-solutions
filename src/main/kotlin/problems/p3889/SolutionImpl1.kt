package problems.p3889

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `96.67%` of Kotlin submissions)
 * - Memory: `61.91 MB` (Beats `13.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/mirror-frequency-distance/solutions/7829883/kotlin-on-12ms-o1-by-alexeyminkin-fh12)
 */
class SolutionImpl1 : Solution {
    override fun mirrorFrequency(s: String): Int {
        val ar = IntArray(36)
        for (c in s.toCharArray()) ar[c - if (c <= '9') '0' else 'W']++
        var res = 0
        for (i in 0..4) res += Math.abs(ar[i] - ar[9 - i])
        for (i in 10..22) res += Math.abs(ar[i] - ar[45 - i])
        return res
    }
}