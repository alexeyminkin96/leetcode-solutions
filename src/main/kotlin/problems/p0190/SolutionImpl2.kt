package problems.p0190

class SolutionImpl2 : Solution {
    companion object {
        val ar = IntArray(256)
    }

    override fun reverseBits(n: Int): Int {
        var varN = n
        var result = 0
        for (i in 0 until 4) {
            result = result shl 8
            result += findRevers(varN and 255)
            varN = varN ushr 8
        }
        return result
    }

    private fun findRevers(n: Int): Int {
        if (ar[n] == 0) ar[n] = reverseByte(n)
        return ar[n]
    }

    private fun reverseByte(n: Int): Int {
        var varN = n
        var result = 0
        for (i in 0 until 8) {
            result = (result shl 1) or (varN and 1)
            varN = varN ushr 1
        }
        return result
    }
}
