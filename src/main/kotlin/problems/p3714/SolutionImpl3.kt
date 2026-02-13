package problems.p3714

class SolutionImpl3 : Solution {
    private val base = 1_000_000L
    private val ar = arrayOf(
        longArrayOf(1, -1, base),
        longArrayOf(base, 1, -1),
        longArrayOf(-1, base, 1),
        longArrayOf(1 + base, -1, -base),
    )
    override fun longestBalanced(s: String): Int {
        val chars = s.toCharArray()
        val previous = Array(ar.size) { mutableMapOf(0L to -1) }
        val prefixes = LongArray(ar.size)
        var last = 0
        var maxCount = 1
        for (i in 0 until chars.size) {
            if (chars[i] != chars[last]) last = i
            else maxCount = maxOf(maxCount, i - last + 1)
            for (c in 0 until ar.size) {
                prefixes[c] += ar[c][chars[i] - 'a']
                val prevInd = previous[c][prefixes[c]]
                if (prevInd == null) previous[c][prefixes[c]] = i
                else maxCount = maxOf(maxCount, i - prevInd)
            }
        }
        return maxCount
    }
}