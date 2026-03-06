package problems.p1784

class SolutionImpl3 : Solution {
    override fun checkOnesSegment(s: String): Boolean {
        val n = s.length
        var i = 1
        while (i < n && s[i] - s[i - 1] != 1) i++
        return i == n
    }
}