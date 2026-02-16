package problems.p0190

class SolutionImpl3 : Solution {
    companion object {
        private var size = 2
        private val ars = Array(5) { IntArray(size).also { size *= size } }

        init {
            ars[0][1] = 1
        }
    }

    override fun reverseBits(n: Int): Int {
        var varN = n
        var result = 0
        for (i in 0 until 2) {
            result = result shl 16
            result += getReverse(4, varN and 0xFFFF)
            varN = varN ushr 16
        }
        return result
    }

    private fun getReverse(arInd: Int, i: Int): Int {
        if (arInd > 0 && ars[arInd][i] == 0) {
            val b = ars[arInd - 1].size.countTrailingZeroBits()
            ars[arInd][i] =
                getReverse(arInd - 1, i and (ars[arInd - 1].size - 1)) shl b or getReverse(arInd - 1, i ushr b)
        }
        return ars[arInd][i]
    }
}
