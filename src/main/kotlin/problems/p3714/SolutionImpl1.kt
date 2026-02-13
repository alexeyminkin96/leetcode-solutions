package problems.p3714

class SolutionImpl1 : Solution {
    private val base = 1_000_000L
    override fun longestBalanced(s: String): Int {
        val chars = s.toCharArray()

        return maxOf(
            oneChar(chars),
            twoChars('a', 'b', chars),
            twoChars('b', 'c', chars),
            twoChars('c', 'a', chars),
            threeChars(chars),
        )
    }

    private fun oneChar(chars: CharArray): Int {
        var last = 0
        var maxCount = 1
        for (i in 1 until chars.size) {
            if (chars[i] != chars[last]) last = i
            else maxCount = maxOf(maxCount, i - last + 1)
        }
        return maxCount
    }

    private fun twoChars(first: Char, second: Char, chars: CharArray): Int {
        var maxCount = 0
        val previous = HashMap<Long, Int>()
        var prefix = 0L
        previous[prefix] = -1
        for (i in 0 until chars.size) {
            prefix += when (chars[i]) {
                first -> 1
                second -> -1
                else -> base
            }
            val prevInd = previous[prefix]
            if (prevInd == null) previous[prefix] = i
            else maxCount = maxOf(maxCount, i - prevInd)
        }
        return maxCount
    }

    private fun threeChars(chars: CharArray): Int {
        var maxCount = 0
        val previous = HashMap<Long, Int>()
        var prefix = 0L
        previous[prefix] = -1
        for (i in 0 until chars.size) {
            prefix += when (chars[i]) {
                'a' -> 1 + base
                'b' -> -1
                else -> -base
            }
            val prevInd = previous[prefix]
            if (prevInd == null) previous[prefix] = i
            else maxCount = maxOf(maxCount, i - prevInd)
        }
        return maxCount
    }
}