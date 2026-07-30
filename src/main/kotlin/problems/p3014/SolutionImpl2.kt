package problems.p3014

class SolutionImpl2 : Solution {
    override fun minimumPushes(word: String): Int {
        var res = 0
        for (i in 0 until word.length) res += i / 8 + 1
        return res
    }
}