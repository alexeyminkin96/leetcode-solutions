package problems.p0762

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.35 MB` (Beats `88.89%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/solutions/7595905/kotlin-on-2ms-o1-swar-by-alexeyminkin-wir9)
 */
class SolutionImpl1 : Solution {
    override fun countPrimeSetBits(left: Int, right: Int): Int {
        var result = 0
        for (i in left..right)
            result += isPrime[bitCount(i)]
        return result
    }

    private fun bitCount(i: Int): Int {
        var i = i
        i = (i and bits1) + ((i ushr 1) and bits1)
        i = (i and bits2) + ((i ushr 2) and bits2)
        i = (i and bits4) + ((i ushr 4) and bits4)
        i = (i and bits8) + ((i ushr 8) and bits8)
        i = (i and bits16) + ((i ushr 16) and bits16)
        return i
    }

    companion object {
        private val bits1 = 0b01010101010101010101010101010101
        private val bits2 = 0b00110011001100110011001100110011
        private val bits4 = 0b00001111000011110000111100001111
        private val bits8 = 0b00000000111111110000000011111111
        private val bits16 = 0b00000000000000001111111111111111

        private val isPrime = IntArray(21)

        init {
            isPrime[2] = 1
            isPrime[3] = 1
            isPrime[5] = 1
            isPrime[7] = 1
            isPrime[11] = 1
            isPrime[13] = 1
            isPrime[17] = 1
            isPrime[19] = 1
        }
    }
}