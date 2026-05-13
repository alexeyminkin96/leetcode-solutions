package problems.p1674

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `33.33%` of Kotlin submissions)
 * - Memory: `64.51 MB` (Beats `0.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + l)`
 * - Space: `O(l)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-moves-to-make-array-complementary/solutions/8214687/kotlin-onl-14ms-ol-by-alexeyminkin-i3ss)
 */
class SolutionImpl1 : Solution {
    override fun minMoves(nums: IntArray, limit: Int): Int {
        val n = nums.size
        val size = limit * 2 + 1
        val sums = IntArray(size)
        val pref = IntArray(size)
        val suf = IntArray(size)
        for (i in 0 until n / 2) {
            sums[nums[i] + nums[n - 1 - i]]++
            pref[Math.max(nums[i], nums[n - 1 - i])]++
            suf[Math.min(nums[i], nums[n - 1 - i])]++
        }
        for (i in 2 until size) {
            pref[i] += pref[i - 1]
            suf[size - 1 - i] += suf[size - i]
        }
        var res = n
        for (i in 2 until size)
            res = Math.min(res, n / 2 - sums[i] + suf[i] + if (i > limit) pref[i - limit - 1] else 0)
        return res
    }
}