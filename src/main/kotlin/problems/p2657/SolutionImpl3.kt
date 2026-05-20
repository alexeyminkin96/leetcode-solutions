package problems.p2657

class SolutionImpl3 : Solution {
    override fun findThePrefixCommonArray(a: IntArray, b: IntArray): IntArray {
        var aBits = 0L
        var bBits = 0L
        for (i in 0 until a.size) {
            aBits = aBits or (1L shl a[i])
            bBits = bBits or (1L shl b[i])
            a[i] = java.lang.Long.bitCount(aBits and bBits)
        }
        return a
    }
}