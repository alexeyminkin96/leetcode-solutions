package problems.p0835

class SolutionImpl1 : Solution {
    override fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val n = img1.size
        var res = 0
        for (y in -(n - 1)..(n - 1)) {
            for (x in -(n - 1)..(n - 1)) {
                var sum = 0
                for (i in Math.max(0, -y) until Math.min(n, n - y))
                    for (j in Math.max(0, -x) until Math.min(n, n - x))
                        sum += img1[i][j] and img2[i + y][j + x]
                res = Math.max(res, sum)
            }
        }
        return res
    }
}