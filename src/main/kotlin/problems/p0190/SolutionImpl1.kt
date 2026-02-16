package problems.p0190

class SolutionImpl1 : Solution {
    override fun reverseBits(n: Int): Int {
        var varN = n
        var result = 0
        for (i in 0 until 32) {
            result = (result shl 1) or (varN and 1)
            varN = varN ushr 1
        }
        return result
    }
}