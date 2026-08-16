package problems.p4021

class SolutionImpl2 : Solution {
    override fun minOperations(s: String): Int {
        val n = s.length
        val s = s.toCharArray()
        var res = Int.MAX_VALUE
        for (i in 0 until n) {
            var sum = i
            for (j in 0 until (n shr 1)) {
                val abs = Math.abs(s[(i + j) % n] - s[(i + n - 1 - j) % n])
                sum += Math.min(abs, 26 - abs)
            }
            res = Math.min(res, sum)
        }
        return res
    }
}