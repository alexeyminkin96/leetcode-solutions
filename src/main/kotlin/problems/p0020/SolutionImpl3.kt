package problems.p0020

class SolutionImpl3 : Solution {
    override fun isValid(s: String): Boolean {
        if (s.length and 1 == 1) return false
        val ar = CharArray(s.length)
        var i = 0
        for (char in s) {
            when (char) {
                '(' -> ar[i++] = ')'
                '[' -> ar[i++] = ']'
                '{' -> ar[i++] = '}'
                else -> if (i == 0 || ar[--i] != char) return false
            }
        }
        return i == 0
    }
}
