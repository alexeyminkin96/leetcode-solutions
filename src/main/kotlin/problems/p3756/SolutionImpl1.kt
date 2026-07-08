package problems.p3756

/**
 * **LeetCode Performance:**
 * - Runtime: `15 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `133.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + q)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/solutions/8383982/kotlin-omq-15ms-om-by-alexeyminkin-clsu)
 */
class SolutionImpl1 : Solution {
    override fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007
        val n = s.length
        val s = s.toCharArray()
        val nz = IntArray(n + 1)
        val ps = IntArray(n + 1)
        val pc = IntArray(n + 1)
        for (i in 1..n) {
            val dig = s[i - 1] - '0'
            nz[i] = nz[i - 1] + if (dig == 0) 0 else 1
            ps[i] = (ps[i - 1] + dig) % mod
            pc[i] = ((dig + pc[i - 1] * if (dig == 0) 1L else 10L) % mod).toInt()
        }
        return IntArray(queries.size) {
            val l = queries[it][0]
            val r = queries[it][1] + 1
            val qSum = ps[r] - ps[l] + mod
            val qCon = pc[r] - pc[l].toLong() * p10[nz[r] - nz[l]] % mod + mod
            ((qSum * qCon) % mod).toInt()
        }
    }
}

private val mod = 1_000_000_007
private var power = 1L
private val p10 = IntArray(100_001) {
    val prev = power
    power = (power * 10) % mod
    prev.toInt()
}