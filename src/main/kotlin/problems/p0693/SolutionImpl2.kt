package problems.p0693

class SolutionImpl2 : Solution {
    override fun hasAlternatingBits(n: Int): Boolean {
        val xor = (n ushr 1) xor n
        return xor and (xor + 1) == 0
    }
}
