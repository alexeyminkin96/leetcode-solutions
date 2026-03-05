package problems.p1758

class SolutionImpl2 : Solution {
    override fun minOperations(s: String): Int {
        val s = s.toByteArray()
        val counts = IntArray(4)
        for (i in 0 until s.size)
            counts[((i and 1) shl 1) or (s[i].toInt() and 1)]++
        return Math.min(counts[0] + counts[3], counts[1] + counts[2])
    }
}