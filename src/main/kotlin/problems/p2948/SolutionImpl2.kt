package problems.p2948

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `33 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `76.37 MB` (Beats `95.91%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/solutions/8499843/kotlin-onlogn-33ms-on-primitives-only-by-ub8u)
 */
class SolutionImpl2 : Solution {
    override fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val n = nums.size
        val numAndIdx = LongArray(n) { nums[it].toLong() shl 32 or it.toLong() }
        Arrays.sort(numAndIdx)
        var groupCount = 1
        var prev = numAndIdx[0] shr 32
        for (i in 1 until n) {
            val num = numAndIdx[i] shr 32
            if (num > prev + limit) groupCount++
            prev = num
        }
        val groupIToIdx = IntArray(groupCount)
        var groupI = 0
        val idxToGroupI = IntArray(n)
        prev = numAndIdx[0] shr 32
        for (i in 0 until n) {
            val num = numAndIdx[i] shr 32
            if (num > prev + limit) groupIToIdx[++groupI] = i
            idxToGroupI[numAndIdx[i].toInt()] = groupI
            numAndIdx[i] = num
            prev = num
        }
        for (i in 0 until n)
            nums[i] = numAndIdx[groupIToIdx[idxToGroupI[i]]++].toInt()
        return nums
    }
}