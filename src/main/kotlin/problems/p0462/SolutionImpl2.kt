package problems.p0462

/**
 * **LeetCode Performance**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `52.55 MB` (Beats `60.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n log (max(nums) - min(nums)))`
 * - Space: `O(1)`.
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/solutions/8598604/koltin-onlogmaxnums-minnums-o1-by-alexey-bmrs)
 */
class SolutionImpl2 : Solution {
    override fun minMoves2(nums: IntArray): Int {
        var l = nums[0]
        var r = nums[0]
        for (num in nums)
            if (num < l) l = num
            else if (num > r) r = num
        while (l < r) {
            val m = (l + r) shr 1
            var c = 0
            for (num in nums) if (num <= m) c++
            if (c <= nums.size shr 1) l = m + 1 else r = m
        }
        var res = 0
        for (num in nums)
            res += Math.abs(l - num)
        return res
    }
}