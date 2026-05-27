package problems.p3121

class SolutionImpl2 : Solution {
    override fun numberOfSpecialChars(word: String): Int {
        var up = 0
        var low = 0
        for (c in word)
            if (c < 'a') up = up or (1 shl (c - 'A'))
            else low = (low or (1 shl (c - 'a'))) and (up and (1 shl (c - 'a'))).inv()
        return (up and low).countOneBits()
    }
}
