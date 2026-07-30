package problems.p3014

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minimumPushes(word: String): Int {
        val counts = IntArray(27)
        for (c in word) counts[c - 'a']++
        Arrays.sort(counts)
        var res = 0
        var i = 0
        while (counts[26 - i] != 0)
            res += counts[26 - i] * (i++ / 8 + 1)
        return res
    }
}