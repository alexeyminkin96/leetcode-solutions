package problems.p2657

class SolutionImpl1 : Solution {
    override fun findThePrefixCommonArray(a: IntArray, b: IntArray): IntArray {
        val n = a.size
        val counts = IntArray(n)
        var count = 0
        return IntArray(n) {
            count += (++counts[a[it] - 1] shr 1) + (++counts[b[it] - 1] shr 1)
            count
        }
    }
}