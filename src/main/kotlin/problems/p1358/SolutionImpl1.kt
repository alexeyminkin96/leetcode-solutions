package problems.p1358

class SolutionImpl1 : Solution {
    override fun numberOfSubstrings(s: String): Int {
        val n = s.length
        var a = 0
        var b = 0
        var c = 0
        var res = 0
        var l = 0
        var r = 0
        while (r < n) {
            while (r < n && a * b * c == 0)
                when (s[r++]) {
                    'a' -> a++
                    'b' -> b++
                    'c' -> c++
                }
            while (a * b * c != 0) {
                res += n - r + 1
                when (s[l++]) {
                    'a' -> a--
                    'b' -> b--
                    'c' -> c--
                }
            }
        }
        return res
    }
}