package problems.p3942

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `165.17 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/solutions/8583449/kotlin-on-3ms-o1-by-alexeyminkin-ssj6)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(nums: IntArray): Int {
        val n = nums.size
        if (n <= 2) return nums[0]
        var prev = nums[n - 1]
        var gapIdx = -1
        for (i in 0 until n) {
            val num = nums[i]
            if (num - prev < -1 || num - prev > 1)
                if (Math.abs(num - prev) != n - 1) return -1 else gapIdx = i
            prev = num
        }
        val incr = (nums[1] - nums[0] == 1 || nums[2] - nums[1] == 1)
        return Math.min(gapIdx + if (incr) 0 else 1, n - gapIdx + 1 + if (incr) 1 else 0)
    }
}