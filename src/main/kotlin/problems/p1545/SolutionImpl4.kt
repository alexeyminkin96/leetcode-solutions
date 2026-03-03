package problems.p1545

class SolutionImpl4 : Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        if (k <= 1) return '0'
        return '0' + (((findKthBit(n, (Integer.highestOneBit(k - 1) shl 1) - k) - '0') + 1) and 1)
    }
}