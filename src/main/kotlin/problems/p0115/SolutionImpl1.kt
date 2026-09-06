package problems.p0115

class SolutionImpl1 : Solution {
    override fun numDistinct(s: String, t: String): Int {
        val n = s.length
        val s = s.toCharArray()
        var curPS = IntArray(n + 1) { 1 }
        var prevPS = IntArray(n + 1)
        for (tChar in t.toCharArray()) {
            val temp = prevPS
            prevPS = curPS
            curPS = temp
            curPS[0] = 0
            for (iS in 0 until n)
                curPS[iS + 1] = curPS[iS] + if (s[iS] == tChar) prevPS[iS] else 0
        }
        return curPS[n]
    }
}