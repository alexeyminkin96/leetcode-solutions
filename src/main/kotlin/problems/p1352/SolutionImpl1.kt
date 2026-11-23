package problems.p1352

class SolutionImpl1 : Solution {
    private var size = 0
    private val ps = IntArray(40_001) { 1 }
    private var prevZero = 0

    override fun add(num: Int) {
        if (num != 0)
            ps[++size] = ps[size - 1] * num
        else
            prevZero = ++size
    }

    override fun getProduct(k: Int): Int {
        return if (prevZero <= size - k) ps[size] / ps[size - k] else 0
    }
}