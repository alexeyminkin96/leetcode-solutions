package problems.p1979

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.86 MB` (Beats `52.38%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + log(m))`, m - min(nums)
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-greatest-common-divisor-of-array/solutions/8404882/kotlin-on-logm-0ms-o1-by-alexeyminkin-nz70)
 */
class SolutionImpl1 : Solution {
    override fun findGCD(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = 0
        for (num in nums) {
            min = Math.min(min, num)
            max = Math.max(max, num)
        }
        return gcd(min, max)
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}