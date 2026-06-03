package problems.p3635

class SolutionImpl1 : Solution {
    override fun earliestFinishTime(lST: IntArray, lD: IntArray, wST: IntArray, wD: IntArray): Int {
        fun findMin(fST: IntArray, fD: IntArray, sST: IntArray, sD: IntArray): Int {
            var fMin = Int.MAX_VALUE
            for (i in 0 until fST.size) fMin = Math.min(fMin, fST[i] + fD[i])
            var res = Int.MAX_VALUE
            for (i in 0 until sST.size) res = Math.min(res, Math.max(fMin, sST[i]) + sD[i])
            return res
        }
        return Math.min(findMin(lST, lD, wST, wD), findMin(wST, wD, lST, lD))
    }
}