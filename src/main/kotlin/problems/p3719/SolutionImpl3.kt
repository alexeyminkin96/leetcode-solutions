package problems.p3719

/**
 * **LeetCode Performance:**
 * - Runtime: `20 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.92 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-balanced-subarray-i/solutions/7568043/kotlin-on2-22ms-oc-sliding-window-back-a-3h8x)
 */
class SolutionImpl3 : Solution {
    override fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        val counts = IntArray(100_001)
        val evenOdds = IntArray(2)
        for (i in 0 until n) add(i, nums, counts, evenOdds)
        if (evenOdds[0] == evenOdds[1]) return n
        var l = 0
        var r = n - 1
        while (l < r) {
            if (delete(r--, nums, counts, evenOdds)) return r - l + 1
            while (r + 1 < n) {
                delete(l++, nums, counts, evenOdds)
                if (add(++r, nums, counts, evenOdds)) return r - l + 1
            }

            if (delete(l++, nums, counts, evenOdds)) return r - l + 1
            while (l - 1 >= 0) {
                delete(r--, nums, counts, evenOdds)
                if (add(--l, nums, counts, evenOdds)) return r - l + 1
            }
        }
        return 0
    }

    private fun delete(i: Int, nums: IntArray, counts: IntArray, evenOdds: IntArray): Boolean {
        if (--counts[nums[i]] == 0) evenOdds[nums[i] and 1]--
        return evenOdds[0] == evenOdds[1]
    }

    private fun add(i: Int, nums: IntArray, counts: IntArray, evenOdds: IntArray): Boolean {
        if (counts[nums[i]]++ == 0) evenOdds[nums[i] and 1]++
        return evenOdds[0] == evenOdds[1]
    }
}