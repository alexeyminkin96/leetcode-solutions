package problems.p0835

/**
 * LeetCode Performance:
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.45 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * Complexity:
 * - Time: `O(n^3)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/image-overlap/solutions/8518968/kotlin-on3-5ms-on-primitives-only-by-ale-oxlz)
 */
class SolutionImpl2 : Solution {
    override fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val n = img1.size
        var res = 0
        val bits1 = IntArray(n)
        val bits2 = IntArray(n)
        for (i in 0 until n)
            for (j in 0 until n) {
                bits1[i] = (bits1[i] shl 1) or img1[i][j]
                bits2[i] = (bits2[i] shl 1) or img2[i][j]
            }
        for (y in -(n - 1)..(n - 1)) {
            for (x in -(n - 1)..(n - 1)) {
                var sum = 0
                if (x >= 0)
                    for (i in Math.max(0, -y) until Math.min(n, n - y))
                        sum += Integer.bitCount((bits1[i] ushr x) and bits2[i + y])
                else
                    for (i in Math.max(0, -y) until Math.min(n, n - y))
                        sum += Integer.bitCount((bits1[i] shl -x) and bits2[i + y])
                res = Math.max(res, sum)
            }
        }
        return res
    }
}