package problems.p2124

class SolutionImpl2 : Solution {
    override fun checkString(s: String): Boolean {
        var prev = 'a'
        for (c in s)
            if (c < prev) return false else prev = c
        return true
    }
}