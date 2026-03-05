package problems.p1758

class SolutionImpl1 : Solution {
    override fun minOperations(s: String): Int {
        val s = s.toByteArray()
        val counts = Array(2) { IntArray(2) }
        for (i in 0 until s.size)
            counts[i and 1][s[i].toInt() and 1]++
        return Math.min(counts[0][1] + counts[1][0], counts[0][0] + counts[1][1])
    }
}