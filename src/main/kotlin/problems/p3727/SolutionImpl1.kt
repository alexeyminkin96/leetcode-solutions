package problems.p3727

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `16 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `80.46 MB` (Beats `58.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(log n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-alternating-sum-of-squares/solutions/8571070/kotlin-onlogn-16ms-on-by-alexeyminkin-qd30)
 */
class SolutionImpl1 : Solution {
    override fun maxAlternatingSum(nums: IntArray): Long {
        return if (nums.size < 1000)
            arraysSort(nums)
        else
            countingSort(nums)
    }

    private fun arraysSort(nums: IntArray): Long {
        val n = nums.size
        for (i in 0 until n)
            if (nums[i] < 0) nums[i] *= -1
        Arrays.sort(nums)
        var res = 0L
        for (i in 0 until (n shr 1))
            res -= nums[i] * nums[i]
        for (i in n shr 1 until n)
            res += nums[i] * nums[i]
        return res
    }

    private fun countingSort(nums: IntArray): Long {
        val n = nums.size
        val sort = IntArray(40_001)
        for (i in 0 until n)
            sort[Math.abs(nums[i])]++
        var res = 0L
        var rem = n shr 1
        var i = 0
        while (sort[i] <= rem) {
            rem -= sort[i]
            res -= i.toLong() * i * sort[i++]
        }
        res -= rem.toLong() * i * i
        sort[i] -= rem
        while (i < 40_001)
            res += i.toLong() * i * sort[i++]
        return res
    }
}