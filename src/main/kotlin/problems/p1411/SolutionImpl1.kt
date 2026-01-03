package problems.p1411

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.07 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun numOfWays(n: Int): Int {
        val mod = 1_000_000_007
        var colors2 = 6L
        var colors3 = 6L
        for (i in 1 until n) {
            colors3 = (colors2 * 2 + colors3 * 2) % mod
            colors2 = (colors2 + colors3) % mod
        }
        return ((colors2 + colors3) % mod).toInt()
    }
}