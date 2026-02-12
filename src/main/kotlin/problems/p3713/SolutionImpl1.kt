package problems.p3713

/**
 * **LeetCode Performance:**
 * - Runtime: `49 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.18 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-balanced-substring-i/solutions/7573505/kotlin-o49ms-n2-o1-by-alexeyminkin-dyux)
 */
class SolutionImpl1 : Solution {
    private val firstChar = 97
    private val size = 26
    override fun longestBalanced(s: String): Int {
        val s = s.toByteArray()
        val n = s.size
        val chars = IntArray(n)
        val charToRepeat = IntArray(size)
        val repeatToCount = IntArray(n + 1)
        repeatToCount[0] = size

        fun isBalanced(charCount: Int): Boolean {
            return repeatToCount[charCount] + repeatToCount[0] == size
        }

        fun move(indexMoved: Int, indexInWindow: Int, moveSize: Int): Boolean {
            charToRepeat[chars[indexMoved]] += moveSize
            val count = charToRepeat[chars[indexMoved]]
            repeatToCount[count - moveSize]--
            repeatToCount[count]++
            return isBalanced(charToRepeat[chars[indexInWindow]])
        }

        for (i in 0 until n) {
            chars[i] = s[i] - firstChar
            move(i, i, 1)
        }
        if (isBalanced(charToRepeat[chars[0]])) return n
        var l = 0
        var r = n - 1
        while (l < r) {
            if (move(r--, r, -1)) return r - l + 1
            while (r + 1 < n) {
                move(l++, l, -1)
                if (move(++r, r, 1)) return r - l + 1
            }

            if (move(l++, l, -1)) return r - l + 1
            while (l - 1 >= 0) {
                move(r--, r, -1)
                if (move(--l, l, 1)) return r - l + 1
            }
        }
        return 0
    }
}