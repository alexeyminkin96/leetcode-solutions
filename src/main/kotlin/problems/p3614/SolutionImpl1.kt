package problems.p3614

/**
 * **LeetCode Performance:**
 * - Runtime: `18 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `51.14 MB` (Beats `10.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/process-string-with-special-operations-ii/solutions/8340296/kotlin-on-18ms-o1-by-alexeyminkin-84sk)
 */
class SolutionImpl1 : Solution {
    override fun processStr(s: String, k: Long): Char {
        var length = 0L
        val s = s.toCharArray()
        for (c in s)
            when (c) {
                '*' -> if (length > 0) length--
                '#' -> length = length shl 1
                '%' -> {}
                else -> length++
            }

        if (k >= length) return '.'
        var k = k
        for (i in s.size - 1 downTo 0) {
            when (s[i]) {
                '*' -> length++
                '#' -> {
                    length = length shr 1
                    if (k >= length) k -= length
                }

                '%' -> k = length - 1 - k
                else -> if (k == --length) return s[i]
            }
        }
        return '.'
    }
}