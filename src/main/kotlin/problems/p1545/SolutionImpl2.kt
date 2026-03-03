package problems.p1545

class SolutionImpl2 : Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        var varK = k - 1
        var size = 1
        while (size - 1 < varK)
            size = (size shl 1) or 1
        var count = 0
        while (varK > 0) {
            if (varK == size ushr 1) return '1' - (count and 1)
            varK = size - 1 - varK
            while ((size ushr 1) - 1 >= varK) size = size ushr 1
            count++
        }
        return '0' + (count and 1)
    }
}