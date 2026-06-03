package problems.p3635

class SolutionImpl2 : Solution {
    override fun earliestFinishTime(lST: IntArray, lD: IntArray, wST: IntArray, wD: IntArray): Int {
        var res = Int.MAX_VALUE
        var lMin = Int.MAX_VALUE
        for (i in 0 until lST.size)
            lMin = Math.min(lMin, lST[i] + lD[i])
        var wMin = Int.MAX_VALUE
        for (i in 0 until wST.size) {
            res = Math.min(res, Math.max(lMin, wST[i]) + wD[i])
            wMin = Math.min(wMin, wST[i] + wD[i])
        }
        for (i in 0 until lST.size)
            res = Math.min(res, Math.max(wMin, lST[i]) + lD[i])
        return res
    }
}