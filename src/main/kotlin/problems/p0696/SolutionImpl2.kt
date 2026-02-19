package problems.p0696

class SolutionImpl2 : Solution {
    override fun countBinarySubstrings(s: String): Int {
        val s = s.toCharArray()
        var lStart = 0
        var rStart = 0
        var result = 0
        for (i in 1 until s.size) {
            if (s[i] == s[rStart]) continue
            result += Math.min(i - rStart, rStart - lStart)
            lStart = rStart
            rStart = i
        }
        result += Math.min(s.size - rStart, rStart - lStart)
        return result
    }
}