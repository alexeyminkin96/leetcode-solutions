package problems.p0761

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.07 MB` (Beats `97.78%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `Θ(n^2)`
 * - Space: `Θ(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/special-binary-string/solutions/7599770/kotlin-on2-1ms-on-no-strings-primitives-7soqu)
 */
class SolutionImpl2 : Solution {
    private val lengthCount = 6
    private val lengthMask = (1L shl lengthCount) - 1
    private val bitsCount = 50
    private val totalCount = bitsCount + lengthCount

    override fun makeLargestSpecial(s: String): String {
        var bits = 0L
        val s = s.toCharArray()
        for (c in s)
            bits = (bits shl 1) or (c - '0').toLong()
        val str = makeLargestSpecial(pack(bits, s.size))
        bits = bits(str)
        for (i in s.size - 1 downTo 0) {
            s[i] = '0' + (bits and 1).toInt()
            bits = bits ushr 1
        }
        return String(s)
    }

    private fun makeLargestSpecial(n: Long): Long {
        val length = length(n)
        if (length == 0) return 0
        val bitsLengths = partition(bits(n), length)
        return sort(bitsLengths, length)
    }

    private fun partition(nBits: Long, nLength: Int): LongArray {
        var balance = 0
        var bits = 0L
        var length = 0
        val bitsLengths = LongArray(nLength / 2 + 1)
        var bitsLengthsCount = 0
        for (i in nLength - 1 downTo 0) {
            val bit = (nBits ushr (i)).toInt() and 1
            balance += (bit shl 1) - 1
            if (balance - bit != 0 && balance != 0) {
                bits = (bits shl 1) or bit.toLong()
                length++
            }
            if (balance == 0) {
                val bitsLength = pack(bits, length)
                val sortedBitsLength = makeLargestSpecial(bitsLength)
                val bitsWithCorners = ((1L shl length) or bits(sortedBitsLength)) shl 1
                bitsLengths[bitsLengthsCount++] = pack(bitsWithCorners, length + 2)
                bits = 0L
                length = 0
            }
        }
        return bitsLengths
    }

    private fun sort(bitsLengths: LongArray, length: Int): Long {
        Arrays.sort(bitsLengths)
        var bits = 0L
        var i = bitsLengths.size
        while (bitsLengths[--i] != 0L)
            bits = (bits shl length(bitsLengths[i])) or bits(bitsLengths[i])
        return pack(bits, length)
    }

    private fun length(n: Long): Int =
        (n and lengthMask).toInt()

    private fun bits(n: Long): Long =
        n ushr (totalCount - length(n))

    private fun pack(bits: Long, size: Int): Long =
        (bits shl (totalCount - size)) or size.toLong()
}