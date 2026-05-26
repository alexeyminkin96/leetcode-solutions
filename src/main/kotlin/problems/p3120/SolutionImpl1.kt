package problems.p3120

class SolutionImpl1 : Solution {
    override fun numberOfSpecialChars(word: String): Int {
        val up = BooleanArray(26)
        val low = BooleanArray(26)
        for (c in word)
            if (c < 'a') up[c - 'A'] = true
            else low[c - 'a'] = true
        var res = 0
        for (i in 0 until 26)
            if (up[i] && low[i]) res++
        return res
    }
}
