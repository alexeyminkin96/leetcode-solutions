package problems.p0788

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.14 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(10000)` precomputation, `O(1)` per call
 * - Space: `O(10000)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/rotated-digits/solutions/8128325/kotlin-on-2m-on-by-alexeyminkin-l6kk)
 */
class SolutionImpl1 : Solution {
    override fun rotatedDigits(n: Int): Int {
        return c[n]
    }

    companion object {
        val dp = IntArray(1_001)
        val c = IntArray(10_010)

        init {
            var idx = -1
            var sum = 0
            for (firstDigs in 0..1_000) {
                val fd = dp[firstDigs]
                for (lastDig in 0..9) {
                    val v = fd + when (lastDig) {
                        0, 1, 8 -> 0
                        2, 5, 6, 9 -> 1
                        else -> -10
                    }
                    if (++idx < 1_000) dp[idx] = v
                    c[idx] = if (v > 0) ++sum else sum
                }
            }
        }
    }
}