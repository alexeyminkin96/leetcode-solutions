package problems.p1520

class SolutionImpl1 : Solution {
    override fun maxNumOfSubstrings(s: String): List<String> {
        val n = s.length
        val s = s.toCharArray(CharArray(n + 1))
        val starts = IntArray(26) { -1 }
        val lengths = IntArray(26) { -1 }
        var prevStart = 0
        for (i in 1..n) {
            val prev = s[i - 1] - 'a'
            if (s[i] - 'a' == prev) continue
            if (starts[prev] == -1) {
                starts[prev] = prevStart
                lengths[prev] = i - prevStart
            } else
                starts[prev] = -2
            prevStart = i
        }
        val res = mutableListOf<String>()
        for (i in 0 until 26)
            if (starts[i] >= 0)
                res.add(String(s, starts[i], lengths[i]))
        return res
    }
}