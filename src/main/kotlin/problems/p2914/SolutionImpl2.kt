package problems.p2914

class SolutionImpl2 : Solution {
    override fun minChanges(s: String): Int {
        val s = s.toCharArray()
        var res = 0
        for (i in 0 until s.size - 1)
            if (s[i] != s[i + 1]) res++
        return res
    }
}