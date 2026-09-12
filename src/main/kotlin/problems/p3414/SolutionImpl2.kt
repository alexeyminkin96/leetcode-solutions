package problems.p3414

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `684 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `102.33 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/solutions/8517699/kotlin-onlogn-684ms-on-primitives-only-b-565k)
 */
class SolutionImpl2 : Solution {
    override fun maximumWeight(intervals: List<List<Int>>): IntArray {
        val n = intervals.size
        val sort = LongArray(n) { (intervals[it][1].toLong() shl 32) or it.toLong() }
        Arrays.sort(sort)
        val dpR = Array(5) { IntArray(n + 1) }
        val dpW = Array(5) { LongArray(n + 1) }
        val dpP = Array(5) { LongArray(n + 1) }
        val idx = IntArray(5) { 1 }
        for (sortI in 0 until n) {
            val intI = sort[sortI].toInt()
            val interval = intervals[intI]
            for (layI in 4 downTo 1) {
                val dpI = idx[layI]
                val prevI = binarySearch(dpR[layI - 1], idx[layI - 1], interval[0])
                val weight = interval[2] + dpW[layI - 1][prevI]
                val packed = addIndex(dpP[layI - 1][prevI], intI)
                if (weight > dpW[layI][dpI - 1] ||
                    weight == dpW[layI][dpI - 1] && java.lang.Long.compareUnsigned(dpP[layI][dpI - 1], packed) > 0
                ) {
                    dpR[layI][dpI] = interval[1]
                    dpW[layI][dpI] = weight
                    dpP[layI][dpI] = packed
                    idx[layI]++
                }
            }
        }
        return result(dpP[4][idx[4] - 1])
    }

    private fun binarySearch(a: IntArray, size: Int, key: Int): Int {
        var l = 0
        var r = size
        while (l < r) {
            val m = (l + r) shr 1
            if (a[m] < key) l = m + 1 else r = m
        }
        return l - 1
    }

    private fun result(packed: Long): IntArray {
        val t = IntArray(4)
        t[0] = (packed ushr 48).toInt() - 1
        t[1] = ((packed ushr 32) and 0xFFFF).toInt() - 1
        t[2] = ((packed ushr 16) and 0xFFFF).toInt() - 1
        t[3] = (packed and 0xFFFF).toInt() - 1
        var r = 3
        while (t[r] == -1) r--
        return t.copyOfRange(0, r + 1)
    }

    private fun addIndex(packed: Long, index: Int): Long {
        var index1 = packed ushr 48
        var index2 = (packed ushr 32) and 0xFFFF
        var index3 = (packed ushr 16) and 0xFFFF
        var index4 = index + 1L

        if (index4 < index3 || index3 == 0L) {
            val t = index3
            index3 = index4
            index4 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        if (index3 < index2 || index2 == 0L) {
            val t = index2
            index2 = index3
            index3 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        if (index2 < index1 || index1 == 0L) {
            val t = index1
            index1 = index2
            index2 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
    }
}