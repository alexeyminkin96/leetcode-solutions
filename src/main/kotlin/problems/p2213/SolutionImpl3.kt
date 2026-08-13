package problems.p2213

class SolutionImpl3 : Solution {
    override fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
        val segTree = SegTree(s)
        return IntArray(queryIndices.size) { segTree.changeChar(queryIndices[it], queryCharacters[it]) }
    }

    private class SegTree(s: String) {
        private val chars = s.toCharArray()
        private val size = if (chars.size == 1) 1 else Integer.highestOneBit(chars.size - 1) shl 1
        private val lCount = IntArray(size shl 1)
        private val rCount = IntArray(size shl 1)
        private val maxLength = IntArray(size shl 1)

        init {
            build(1, 0, chars.size - 1)
        }

        fun changeChar(i: Int, c: Char): Int {
            if (chars[i] == c) return maxLength[1]
            chars[i] = c
            update(1, 0, chars.size - 1, i)
            return maxLength[1]
        }

        private fun build(i: Int, l: Int, r: Int) {
            if (l == r) {
                lCount[i] = 1
                rCount[i] = 1
                maxLength[i] = 1
            } else {
                val mid = (l + r) shr 1
                build(i shl 1, l, mid)
                build((i shl 1) + 1, mid + 1, r)
                merge(i, l, r)
            }
        }

        private fun update(i: Int, l: Int, r: Int, pos: Int) {
            if (l == r) return
            val mid = (l + r) shr 1
            if (pos <= mid)
                update(i shl 1, l, mid, pos)
            else
                update((i shl 1) + 1, mid + 1, r, pos)
            merge(i, l, r)
        }

        private fun merge(i: Int, l: Int, r: Int) {
            val left = i shl 1
            val right = left + 1
            val mid = (l + r) shr 1
            lCount[i] =
                lCount[left] + if (chars[mid] == chars[mid + 1] && lCount[left] == mid - l + 1) lCount[right] else 0
            rCount[i] =
                rCount[right] + if (chars[mid] == chars[mid + 1] && rCount[right] == r - mid) rCount[left] else 0
            maxLength[i] = maxOf(
                maxLength[left],
                maxLength[right],
                if (chars[mid] == chars[mid + 1]) rCount[left] + lCount[right] else 0
            )
        }
    }
}