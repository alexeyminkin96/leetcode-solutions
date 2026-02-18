package problems.p0693

class SolutionImpl3 : Solution {
    override fun hasAlternatingBits(n: Int): Boolean {
        return n and (n ushr 1) == 0 && n and (n ushr 2) == n ushr 2
    }
}
