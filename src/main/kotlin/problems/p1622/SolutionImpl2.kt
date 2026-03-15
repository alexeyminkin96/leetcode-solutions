package problems.p1622

class SolutionImpl2 : Solution {
    private val ar = ArrayList<Int>()
    private val moves = ArrayList<Int>()
    private val firstMove = ArrayList<Int>()
    override fun append(`val`: Int) {
        ar.add(`val`)
        firstMove.add(moves.size)
    }

    override fun addAll(inc: Int) {
        moves.add(inc * 1_000)
    }

    override fun multAll(m: Int) {
        moves.add(m)
    }

    override fun getIndex(idx: Int): Int {
        if (idx >= ar.size) return -1
        val mod = 1_000_000_007
        var result = ar[idx].toLong()
        for (i in firstMove[idx] until moves.size) {
            val inc = moves[i] / 1_000
            if (inc != 0) result += inc
            else result *= moves[i]
            if (result >= mod) result %= mod
        }
        return result.toInt()
    }
}