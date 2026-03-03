package problems.p1545

class SolutionImpl1 : Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        return '0' + chars[k - 1]
    }

    companion object {
        private val MAX_N = 20
        private val chars: IntArray

        init {
            var size = 1
            for (i in 1 until MAX_N)
                size = (size shl 1) or 1
            chars = IntArray(size)
            var r = 1
            for (i in 1 until MAX_N) {
                chars[r] = 1
                var l = r++ - 1
                while (l >= 0)
                    chars[r++] = (chars[l--] + 1) and 1
            }
        }
    }
}