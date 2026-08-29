package problems.p2948

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val n = nums.size
        val sort = nums.sortedArray()
        var groupCount = 1
        for (i in 1 until n) if (sort[i] > sort[i - 1] + limit) groupCount++
        val groupStarts = IntArray(groupCount)
        val groupIdxs = IntArray(groupCount)
        var groupI = 0
        groupStarts[groupI++] = sort[0]
        for (i in 1 until n)
            if (sort[i] > sort[i - 1] + limit) {
                groupStarts[groupI] = sort[i]
                groupIdxs[groupI++] = i
            }
        for (i in 0 until n) {
            var startIdx = Arrays.binarySearch(groupStarts, nums[i])
            if (startIdx < 0) startIdx = -startIdx - 2
            nums[i] = sort[groupIdxs[startIdx]++]
        }
        return nums
    }
}