package problems.p2897

/**
 * **LeetCode Performance:**
 * - Runtime: `18 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `71.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((n + k)*C)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/solutions/8568448/kotlin-onks-18ms-os-by-alexeyminkin-01za)
 */
class SolutionImpl1 : Solution {
    override fun maxSum(nums: List<Int>, k: Int): Int {
        val bits = IntArray(31)
        for (num in nums)
            for (i in 0..30)
                bits[i] += (num shr i) and 1
        var res = 0L
        for (i in 0 until k) {
            var num = 0L
            for (b in 30 downTo 0) {
                num = num shl 1
                if (bits[b]-- > 0) num = num or 1
            }
            res = (res + num * num) % 1_000_000_007
        }
        return res.toInt()
    }
}