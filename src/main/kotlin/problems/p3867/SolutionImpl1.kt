package problems.p3867

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `57 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `76.54 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n (log(n) + log(m)))`, m - max(nums)
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/solutions/8400972/kotlin-onlognlogm-57ms-on-by-alexeyminki-7mnd)
 */
class SolutionImpl1 : Solution {
    override fun gcdSum(nums: IntArray): Long {
        val n = nums.size
        var max = 0
        val prefixGcd = IntArray(n) {
            max = Math.max(max, nums[it])
            gcd(nums[it], max)
        }
        Arrays.sort(prefixGcd)
        var sum = 0L
        for (i in 0 until (n shr 1))
            sum += gcd(prefixGcd[i], prefixGcd[n - i - 1])
        return sum
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