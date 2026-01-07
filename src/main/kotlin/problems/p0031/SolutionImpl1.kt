package problems.p0031

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.47 MB` (Beats `98.40%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/next-permutation/solutions/7474774/kotlin-on-0ms-o1-by-alexeyminkin-23vo)
 */
class SolutionImpl1 : Solution {
    override fun nextPermutation(nums: IntArray) {
        val last = nums.size - 1
        var i = last
        while (i > 0 && nums[i - 1] >= nums[i]) i--
        var l = i
        var r = last
        while (l < r) swap(l++, r--, nums)
        if (i == 0) return
        l = i - 1
        r = i
        while (r < last && nums[l] >= nums[r]) r++
        swap(l, r, nums)
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val buf = nums[i]
        nums[i] = nums[j]
        nums[j] = buf
    }
}