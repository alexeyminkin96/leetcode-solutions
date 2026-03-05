package problems.p1758

class SolutionImpl4 : Solution {
    override fun minOperations(s: String): Int {
        val s = s.toByteArray()
        var counts = 0
        for (i in 0 until s.size)
            counts += (i and 1) xor (s[i].toInt() and 1)
        return Math.min(counts, s.size - counts)
    }
}