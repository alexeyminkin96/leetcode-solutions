package problems.p1352

import java.util.Arrays

class SolutionImpl2 : Solution {
    private var allCount = 0
    private var non1Count = 0
    private val ps = IntArray(32) { 1 }
    private val counts = IntArray(32)

    override fun add(num: Int) {
        when (num) {
            0 -> {
                allCount = 0
                non1Count = 0
            }

            1 -> allCount++
            else -> {
                ps[++non1Count] = ps[non1Count - 1] * num
                counts[non1Count] = ++allCount
            }
        }
    }

    override fun getProduct(k: Int): Int {
        if (allCount < k) return 0
        var pos = Arrays.binarySearch(counts, 1, non1Count + 1, allCount - k)
        if (pos < 0) pos = -pos - 2
        return ps[non1Count] / ps[pos]
    }
}