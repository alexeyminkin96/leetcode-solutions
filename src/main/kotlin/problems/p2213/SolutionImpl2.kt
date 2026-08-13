package problems.p2213

/**
 * **LeetCode Performance:**
 * - Runtime: 76 ms — Beats 100.00% of Kotlin submissions
 * - Memory: 65.99 MB — Beats 100.00% of Kotlin submissions
 *
 * **Complexity:**
 * - Time: O(k log n)
 * - Space: O(n)
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/longest-substring-of-one-repeating-character/solutions/8458724/kotlin-oklogn-76ms-on-by-alexeyminkin-66o5)
 */
class SolutionImpl2 : Solution {
    override fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
        val segTree = SegTree(s)
        return IntArray(queryIndices.size) { segTree.changeChar(queryIndices[it], queryCharacters[it]) }
    }

    private class SegTree(s: String) {
        private val chars = s.toCharArray()
        private val size = if (chars.size == 1) 1 else Integer.highestOneBit(chars.size - 1) shl 1
        private val lChar = CharArray(size shl 1)
        private val rChar = CharArray(size shl 1)
        private val lCount = IntArray(size shl 1)
        private val rCount = IntArray(size shl 1)
        private val len = IntArray(size shl 1)
        private val maxLength = IntArray(size shl 1)

        init {
            for (i in 0 until chars.size) {
                val pos = size + i
                lChar[pos] = chars[i]
                rChar[pos] = chars[i]
                lCount[pos] = 1
                rCount[pos] = 1
                len[pos] = 1
                maxLength[pos] = 1
            }
            for (i in size - 1 downTo 1) merge(i)
        }

        fun changeChar(i: Int, c: Char): Int {
            var pos = i + size
            if (lChar[pos] == c) return maxLength[1]
            lChar[pos] = c
            rChar[pos] = c
            while (pos != 1) {
                pos = pos shr 1
                merge(pos)
            }
            return maxLength[1]
        }

        private fun merge(i: Int) {
            val l = i shl 1
            val r = l + 1
            if (len[l] == 0) return
            if (len[r] == 0) {
                lChar[i] = lChar[l]
                rChar[i] = rChar[l]
                lCount[i] = lCount[l]
                rCount[i] = rCount[l]
                len[i] = len[l]
                maxLength[i] = maxLength[l]
                return
            }
            lChar[i] = lChar[l]
            rChar[i] = rChar[r]
            lCount[i] = lCount[l] + if (rChar[l] == lChar[r] && lCount[l] == len[l]) lCount[r] else 0
            rCount[i] = rCount[r] + if (rChar[l] == lChar[r] && rCount[r] == len[r]) rCount[l] else 0
            len[i] = len[l] + len[r]
            maxLength[i] = maxOf(maxLength[l], maxLength[r], if (rChar[l] == lChar[r]) rCount[l] + lCount[r] else 0)
        }
    }
}