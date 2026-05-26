package problems.p3120

class SolutionImpl2 : Solution {
    override fun numberOfSpecialChars(word: String): Int {
        val counts = IntArray(26)
        for (c in word)
            if (c < 'a') counts[c - 'A']++
            else counts[c - 'a'] += 100
        var res = 0
        for (i in 0 until 26)
            if (counts[i] >= 100 && counts[i] % 100 > 0) res++
        return res
    }
}
