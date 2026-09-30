package problems.p1111

class SolutionImpl2 : Solution {
    override fun maxDepthAfterSplit(seq: String): IntArray {
        val n = seq.length
        var aDepth = 0
        var bDepth = 0
        val res = IntArray(n)
        for (i in 0 until n) {
            if (seq[i] == '(') {
                if (aDepth > bDepth) {
                    bDepth++
                    res[i] = 1
                } else {
                    aDepth++
                    res[i] = 0
                }
            } else {
                if (aDepth > bDepth) {
                    aDepth--
                    res[i] = 0
                } else {
                    bDepth--
                    res[i] = 1
                }
            }
        }
        return res
    }
}