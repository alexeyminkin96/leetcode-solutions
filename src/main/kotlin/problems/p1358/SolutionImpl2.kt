package problems.p1358

class SolutionImpl2 : Solution {
    override fun numberOfSubstrings(s: String): Int {
        val n = s.length
        val c = IntArray(3)
        var res = 0
        var l = 0
        var r = 0
        while (r < n) {
            while (r < n && c[0] * c[1] * c[2] == 0) c[s[r++] - 'a']++
            if (c[0] * c[1] * c[2] != 0)
                do res += n - r + 1 while (--c[s[l++] - 'a'] != 0)
        }
        return res
    }
}