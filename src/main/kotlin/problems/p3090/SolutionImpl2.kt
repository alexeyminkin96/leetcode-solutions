package problems.p3090

class SolutionImpl2 : Solution {
    override fun maximumLengthSubstring(s: String): Int {
        val counts = IntArray(26)
        var l = 0
        var res = 0
        for (r in 0 until s.length) {
            if (++counts[s[r] - 'a'] == 3) {
                res = Math.max(res, r - l)
                while (counts[s[l++] - 'a']-- != 3);
            }
        }
        return Math.max(res, s.length - l)
    }
}