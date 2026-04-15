package problems.p0005

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.09 MB` (Beats `65.41%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    override fun longestPalindrome(s: String): String {
        val n = (s.length shl 1) + 1
        val s = s.toCharArray()
        val sMod = CharArray(n) { if (it and 1 == 0) ' ' else s[it shr 1] }
        val rads = IntArray(n)
        var maxC = 0
        var maxRad = 0
        var c = 0
        var r = 0
        for (i in 0 until n) {
            var rad = if (i <= r) Math.min(rads[(c shl 1) - i], r - i) else 0
            while (i - rad >= 0 && i + rad < n && sMod[i - rad] == sMod[i + rad]) rad++
            rads[i] = --rad
            if (i + rad > r) {
                c = i
                r = i + rad
            }
            if (rad > maxRad) {
                maxRad = rad
                maxC = i
            }
        }
        return String(CharArray(maxRad) { s[((maxC - maxRad) shr 1) + it] })
    }
}
