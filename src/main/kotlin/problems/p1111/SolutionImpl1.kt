package problems.p1111

class SolutionImpl1 : Solution {
    override fun maxDepthAfterSplit(seq: String): IntArray {
        val n = seq.length
        var maxDepth = 0
        var curDepth = 0
        for (c in seq) if (c == '(') maxDepth = Math.max(maxDepth, ++curDepth) else curDepth--
        var aDepth = 0
        var bDepth = 0
        val res = IntArray(n)
        for (i in 0 until n) {
            if (seq[i] == '(') {
                if (aDepth < maxDepth shr 1) {
                    aDepth++
                    res[i] = 0
                } else {
                    bDepth++
                    res[i] = 1
                }
            } else {
                if (bDepth > 0) {
                    bDepth--
                    res[i] = 1
                } else {
                    aDepth--
                    res[i] = 0
                }
            }
        }
        return res
    }
}