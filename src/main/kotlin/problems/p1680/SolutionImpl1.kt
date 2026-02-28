package problems.p1680

/**
 * **LeetCode Performance:**
 * - Runtime: `113 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.14 MB` (Beats `20.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun concatenatedBinary(n: Int): Int {
        val base = 1_000_000_007
        var num = 0L
        var bitCount = 1
        var nextRise = 2
        for (i in 1..n) {
            if (i == nextRise) {
                bitCount++
                nextRise = nextRise shl 1
            }
            num = (num shl bitCount) or i.toLong()
            if (num > base) num %= base
        }
        return num.toInt()
    }
}