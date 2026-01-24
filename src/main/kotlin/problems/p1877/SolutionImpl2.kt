package problems.p1877

/**
 * **LeetCode Performance:**
 * - Runtime: `397 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `63.69 MB` (Beats `40.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + K)`
 * - Space: `O(K)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/solutions/7521203/kotlin-on-k-397ms-ok-by-alexeyminkin-wqmm)
 */
class SolutionImpl2 : Solution {
    override fun minPairSum(nums: IntArray): Int {
        val sort = IntArray(100_001)
        var l = sort.size - 1
        var r = 0
        for (i in 0 until nums.size) {
            if (nums[i] < l) l = nums[i]
            if (nums[i] > r) r = nums[i]
            sort[nums[i]]++
        }
        var max = 0
        for (i in 0 until nums.size / 2) {
            while (sort[l]-- == 0) l++
            while (sort[r]-- == 0) r--
            val sum = l + r
            if (sum > max) max = sum
        }
        return max
    }
}