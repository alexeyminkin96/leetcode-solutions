package problems.p3130

/**
 * **LeetCode Performance:**
 * - Runtime: `65 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `65.58 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(zero * one)`
 * - Space: `O(zero * one)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/solutions/7638267/kotlin-ozo-65ms-ozo-2-2d-arrays-by-alexe-i4ho)
 */
class SolutionImpl1 : Solution {
    override fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val mod = 1_000_000_007L
        val dp0 = Array(zero + 1) { LongArray(one + 1) }
        val dp1 = Array(zero + 1) { LongArray(one + 1) }

        for (i in 1..Math.min(limit, zero)) dp0[i][0] = 1
        for (i in 1..Math.min(limit, one)) dp1[0][i] = 1

        for (z in 1..zero) {
            for (o in 1..one) {
                val minus0 = if (z - limit - 1 >= 0) dp1[z - limit - 1][o] else 0
                dp0[z][o] = (dp0[z - 1][o] + dp1[z - 1][o] + mod - minus0) % mod
                val minus1 = if (o - limit - 1 >= 0) dp0[z][o - limit - 1] else 0
                dp1[z][o] = (dp0[z][o - 1] + dp1[z][o - 1] + mod - minus1) % mod
            }
        }
        return ((dp0[zero][one] + dp1[zero][one]) % mod).toInt()
    }
}