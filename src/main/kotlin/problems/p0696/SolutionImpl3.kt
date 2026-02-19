package problems.p0696

class SolutionImpl3 : Solution {
    override fun countBinarySubstrings(s: String): Int {
        val s = s.toCharArray()
        var lStart = 0
        var rStart = 0
        var result = 0
        for (i in 1 until s.size) {
            if (s[i] != s[rStart]) {
                lStart = rStart
                rStart = i
            }
            if (i - rStart < rStart - lStart) result++
        }
        return result
    }
}