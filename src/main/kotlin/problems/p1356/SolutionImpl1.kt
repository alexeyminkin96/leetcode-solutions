package problems.p1356

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.57 MB` (Beats `92.86%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun sortByBits(arr: IntArray): IntArray {
        for (i in 0 until arr.size)
            arr[i] = (bitCount(arr[i]) shl 16) or arr[i]
        Arrays.sort(arr)
        for (i in 0 until arr.size)
            arr[i] = arr[i] and 0b1111111111111111  //16 bits
        return arr
    }

    private val bit1 = 0b0101010101010101
    private val bit2 = 0b0011001100110011
    private val bit4 = 0b0000111100001111
    private val bit8 = 0b0000000011111111
    private fun bitCount(i: Int): Int {
        var i = i
        i = (i and bit1) + ((i ushr 1) and bit1)
        i = (i and bit2) + ((i ushr 2) and bit2)
        i = (i and bit4) + ((i ushr 4) and bit4)
        i = (i and bit8) + (i ushr 8)
        return i
    }
}