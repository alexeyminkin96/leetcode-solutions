package problems.p3714

/**
 * **LeetCode Performance:**
 * - Runtime: `218 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.99 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-balanced-substring-ii/solutions/7576032/kotlin-on2s-c-218ms-on2s-c-one-pass-by-a-74z7)
 */
class SolutionImpl2 : Solution {
    private val base = 1_000_000L
    override fun longestBalanced(s: String): Int {
        val chars = s.toCharArray()
        return maxOf(
            oneChar(chars),
            moreChars(chars, 1, -1, base),
            moreChars(chars, base, 1, -1),
            moreChars(chars, -1, base, 1),
            moreChars(chars, 1 + base, -1, -base),
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

    private fun moreChars(chars: CharArray, a: Long, b: Long, c: Long): Int {
        var maxCount = 0
        val previous = HashMap<Long, Int>()
        var prefix = 0L
        previous[prefix] = -1
        for (i in 0 until chars.size) {
            prefix += when (chars[i]) {
                'a' -> a
                'b' -> b
                else -> c
            }
            val prevInd = previous[prefix]
            if (prevInd == null) previous[prefix] = i
            else maxCount = maxOf(maxCount, i - prevInd)
        }
        return maxCount
    }
}