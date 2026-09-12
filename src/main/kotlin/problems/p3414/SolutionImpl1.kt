package problems.p3414

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun maximumWeight(intervals: List<List<Int>>): IntArray {
        val n = intervals.size
        val sort = LongArray(n) { (intervals[it][1].toLong() shl 32) or it.toLong() }
        Arrays.sort(sort)
        val dp = Array(5) { mutableListOf(Triple(-1, 0L, 0L)) }
        for (sortI in 0 until n) {
            val i = sort[sortI].toInt()
            val interval = intervals[i]
            for (k in 4 downTo 1) {
                val bestPrevLay = dp[k - 1].findLast { it.first < interval[0] }!!
                val weight = interval[2] + bestPrevLay.second
                val packed = addIndex(bestPrevLay.third, i)
                if (weight > dp[k].last().second ||
                    weight == dp[k].last().second && java.lang.Long.compareUnsigned(dp[k].last().third, packed) > 0
                )
                    dp[k].add(Triple(interval[1], weight, packed))
            }
        }
        return result(dp[4].last().third)
    }

    private fun result(packed: Long): IntArray {
        val t = IntArray(4)
        t[0] = (packed ushr 48).toInt() - 1
        t[1] = ((packed ushr 32) and 0xFFFF).toInt() - 1
        t[2] = ((packed ushr 16) and 0xFFFF).toInt() - 1
        t[3] = (packed and 0xFFFF).toInt() - 1
        return when {
            t[3] != -1 -> t
            t[2] != -1 -> t.copyOfRange(0, 3)
            t[1] != -1 -> t.copyOfRange(0, 2)
            else -> t.copyOfRange(0, 1)
        }
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

    private fun addIndex2(packed: Long, index: Int): Long {
        var index1 = index + 1L
        var index2 = (packed ushr 32) and 0xFFFF
        var index3 = (packed ushr 16) and 0xFFFF
        var index4 = (packed) and 0xFFFF

        if (index2 < index1 || index2 == 0L) {
            val t = index1
            index1 = index2
            index2 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        if (index3 < index2 || index3 == 0L) {
            val t = index2
            index2 = index3
            index3 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        if (index4 < index3 || index4 == 0L) {
            val t = index3
            index3 = index4
            index4 = t
        } else return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
        return (index1 shl 48) or (index2 shl 32) or (index3 shl 16) or index4
    }
}