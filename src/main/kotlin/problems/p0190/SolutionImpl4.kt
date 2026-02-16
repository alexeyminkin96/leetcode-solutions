package problems.p0190

/**
 * **LeetCode Performance:**
 * - Runtime: `85 ms` (Beats `87.50%` of Kotlin submissions)
 * - Memory: `39.73 MB` (Beats `69.74%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)` (O(log(log(n)) - exactly 5 steps)
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/reverse-bits/solutions/7583655/kotlin-ologlogn-o85ms-o1-by-alexeyminkin-j2a7)
 */
class SolutionImpl4 : Solution {
    private val bits16l = 0b1111_1111_1111_1111_0000_0000_0000_0000.toInt()
    private val bits16r = 0b0000_0000_0000_0000_1111_1111_1111_1111
    private val bits8l = 0b1111_1111_0000_0000_1111_1111_0000_0000.toInt()
    private val bits8r = 0b0000_0000_1111_1111_0000_0000_1111_1111
    private val bits4l = 0b1111_0000_1111_0000_1111_0000_1111_0000.toInt()
    private val bits4r = 0b0000_1111_0000_1111_0000_1111_0000_1111
    private val bits2l = 0b1100_1100_1100_1100_1100_1100_1100_1100.toInt()
    private val bits2r = 0b0011_0011_0011_0011_0011_0011_0011_0011
    private val bits1l = 0b1010_1010_1010_1010_1010_1010_1010_1010.toInt()
    private val bits1r = 0b0101_0101_0101_0101_0101_0101_0101_0101

    override fun reverseBits(n: Int): Int {
        var varN = n
        varN = ((varN and bits16l) ushr 16) or ((varN and bits16r) shl 16)
        varN = ((varN and bits8l) ushr 8) or ((varN and bits8r) shl 8)
        varN = ((varN and bits4l) ushr 4) or ((varN and bits4r) shl 4)
        varN = ((varN and bits2l) ushr 2) or ((varN and bits2r) shl 2)
        varN = ((varN and bits1l) ushr 1) or ((varN and bits1r) shl 1)
        return varN
    }
}
