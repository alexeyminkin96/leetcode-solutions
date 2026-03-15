package problems.p1622

class SolutionImpl1 : Solution {
    private val ar = ArrayList<Int>()
    override fun append(`val`: Int) {
        ar.add(`val`)
    }

    override fun addAll(inc: Int) {
        val mod = 1_000_000_007
        for (i in 0 until ar.size) {
            var value = ar[i] + inc
            if (value >= mod) value %= mod
            ar[i] = value
        }
    }

    override fun multAll(m: Int) {
        val mod = 1_000_000_007
        for (i in 0 until ar.size) {
            var value = ar[i].toLong() * m
            if (value >= mod) value %= mod
            ar[i] = value.toInt()
        }
    }

    override fun getIndex(idx: Int): Int {
        return if (idx >= ar.size) -1
        else ar[idx]
    }
}