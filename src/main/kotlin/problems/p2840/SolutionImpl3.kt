package problems.p2840

class SolutionImpl3 : Solution {
    override fun checkStrings(s1: String, s2: String): Boolean {
        val counts = IntArray(26)
        for (i in 0 until s1.length) {
            counts[s1[i] - 'a'] += 1 shl ((i and 1) shl 4)
            counts[s2[i] - 'a'] -= 1 shl ((i and 1) shl 4)
        }
        for (i in 0 until 26) if (counts[i] != 0) return false
        return true
    }
}