package problems.p1411

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.44 MB` (Beats `33.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(5000)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/solutions/7461427/kotlin-on-1ms-on-caching-by-alexeyminkin-hv3q)
 */
class SolutionImpl2 : Solution {
    companion object {
        private const val mod = 1_000_000_007
        private val colors2 = LongArray(5001)
        private val colors3 = LongArray(5001)
        private var last = 1

        init {
            colors2[1] = 6
            colors3[1] = 6
        }
    }

    override fun numOfWays(n: Int): Int {
        while (last < n) {
            last++
            colors3[last] = (colors2[last - 1] * 2 + colors3[last - 1] * 2) % mod
            colors2[last] = (colors2[last - 1] * 3 + colors3[last - 1] * 2) % mod
        }
        return ((colors2[n] + colors3[n]) % mod).toInt()
    }
}