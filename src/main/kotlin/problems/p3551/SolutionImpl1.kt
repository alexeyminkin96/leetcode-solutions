package problems.p3551

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `106 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `188.48 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/solutions/8576685/kotlin-onlogn-106ms-on-by-alexeyminkin-qkjc)
 */
class SolutionImpl1 : Solution {
    override fun minSwaps(nums: IntArray): Int {
        val n = nums.size
        val sort = LongArray(n) { (digSum(nums[it]).toLong() shl 50) or (nums[it].toLong() shl 17) or it.toLong() }
        Arrays.sort(sort)
        var res = 0
        for (i in 0 until n) {
            if (sort[i] < 0) continue
            res--
            var nextI = i
            while (sort[nextI] > 0) {
                val nextNextI = (sort[nextI] and ((1 shl 17) - 1)).toInt()
                sort[nextI] = -1
                nextI = nextNextI
                res++
            }
        }
        return res
    }

    private fun digSum(num: Int): Int {
        var num = num
        var digSum = 0
        while (num != 0) {
            digSum += num % 10
            num /= 10
        }
        return digSum
    }
}