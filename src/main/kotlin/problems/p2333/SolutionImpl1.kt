package problems.p2333

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
        val n = nums1.size
        val sort = IntArray(n + 1)
        for (i in 0 until n)
            sort[i] = Math.abs(nums1[i] - nums2[i])
        Arrays.sort(sort)
        var changes = 0L + k1 + k2
        var changeCount = 1L
        var i = n
        while (i > 0) {
            val remove = (sort[i] - sort[i - 1]) * changeCount
            if (remove > changes) break
            changes -= remove
            changeCount++
            i--
        }
        if (sort[i] == 0) return 0
        var res = 0L
        for (j in 1 until i)
            res += sort[j].toLong() * sort[j]
        val maxNum = sort[i] - changes / changeCount
        val decrMaxNum = maxNum - 1
        val decrMaxNumCount = changes % changeCount
        val maxNumCount = changeCount - decrMaxNumCount
        res += maxNumCount * maxNum * maxNum + decrMaxNumCount * decrMaxNum * decrMaxNum
        return res
    }
}