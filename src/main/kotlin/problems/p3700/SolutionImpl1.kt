package problems.p3700

/**
 * **LeetCode Performance:**
 * - Runtime: `160 ms` (Beats `54.84%` of Kotlin submissions)
 * - Memory: `48.34 MB` (Beats `59.68%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((r - l)^3 * log n)`
 * - Space: `O((r - l)^2)`
 */
class SolutionImpl1 : Solution {
    override fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val mod = 1_000_000_007
        val m = r - l + 1
        val size = m shl 1
        var dp = LongArray(size) { if (it < m) it.toLong() else (size - 1 - it).toLong() }
        var mat = Array(size) { LongArray(size) }
        for (i in 0 until m) {
            for (j in 0 until i)
                mat[i][m + j] = 1L
            for (j in i + 1 until m)
                mat[m + i][j] = 1L
        }
        var pow = n - 2
        while (pow > 0) {
            if (pow and 1 == 1)
                dp = LongArray(size) {
                    var cur = 0L
                    for (j in 0 until size)
                        cur = (cur + mat[it][j] * dp[j]) % mod
                    cur
                }
            val nMat = Array(size) { LongArray(size) }
            for (i in 0 until size) {
                for (k in 0 until size) {
                    if (mat[i][k] == 0L) continue
                    for (j in 0 until size)
                        nMat[i][j] = (nMat[i][j] + mat[i][k] * mat[k][j]) % mod
                }
            }
            mat = nMat
            pow = pow shr 1
        }
        var res = 0L
        for (x in dp) res += x
        return (res % mod).toInt()
    }
}