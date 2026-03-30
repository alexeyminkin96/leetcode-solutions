package problems.p2840

class SolutionImpl1 : Solution {
    override fun checkStrings(s1: String, s2: String): Boolean {
        val counts = Array(2) { IntArray(26) }
        for (i in 0 until s1.length) {
            counts[i and 1][s1[i] - 'a']++
            counts[i and 1][s2[i] - 'a']--
        }
        for (i in 0 until 26)
            if (counts[0][i] != 0 || counts[1][i] != 0) return false
        return true
    }
}