package problems.p3699

/**
 * **LeetCode Performance:**
 * - Runtime: `121 ms` (Beats `97.73%` of Kotlin submissions)
 * - Memory: `46.57 MB` (Beats `62.50%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * (r - l))`
 * - Space: `O(r - l)`
 */
class SolutionImpl1 : Solution {
    override fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val mod = 1_000_000_007
        val m = r - l + 1
        var up = IntArray(m) { it }
        var down = IntArray(m) { m - 1 - it }
        var nUp = IntArray(m)
        var nDown = IntArray(m)
        for (k in 0 until n - 2) {
            var sum = 0
            for (i in 0 until m) {
                nUp[i] = sum
                sum += down[i]
                if (sum >= mod) sum -= mod
            }
            sum = 0
            for (i in m - 1 downTo 0) {
                nDown[i] = sum
                sum += up[i]
                if (sum >= mod) sum -= mod
            }
            val upBuf = up
            val downBuf = down
            up = nUp
            down = nDown
            nUp = upBuf
            nDown = downBuf
        }
        var res = 0L
        for (i in 0 until m) res += up[i] + down[i]
        return (res % mod).toInt()
    }
}