package problems.p1111

class SolutionImpl3 : Solution {
    override fun maxDepthAfterSplit(seq: String): IntArray {
        val n = seq.length
        var diff = 0
        val res = IntArray(n)
        for (i in 0 until n) {
            res[i] = (diff + (seq[i] - '(')) and 1
            diff = 1 - diff
        }
        return res
    }
}