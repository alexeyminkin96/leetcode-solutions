package problems.p0696

class SolutionImpl1 : Solution {
    override fun countBinarySubstrings(s: String): Int {
        val s = s.toCharArray()
        var result = 0
        var prevCount = 0
        var start = 0
        for (i in 1 until s.size) {
            if (s[i] == s[start]) continue
            val count = i - start
            result += Math.min(count, prevCount)
            prevCount = count
            start = i
        }
        result += Math.min(s.size - start, prevCount)
        return result
    }
}