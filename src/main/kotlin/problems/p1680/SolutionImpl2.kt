package problems.p1680

/**
 * **LeetCode Performance:**
 * - Runtime: `94 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.59 MB` (Beats `20.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/solutions/7615441/kotlin-on-94ms-oc-by-alexeyminkin-14hj)
 */
class SolutionImpl2 : Solution {
    override fun concatenatedBinary(n: Int): Int {
        return ar[n].toInt()
    }

    companion object {
        private val ar = LongArray(100_001)

        init {
            val base = 1_000_000_007
            var num = 0L
            var bitCount = 1
            var nextRise = 2
            for (i in 1 until ar.size) {
                if (i == nextRise) {
                    bitCount++
                    nextRise = nextRise shl 1
                }
                num = (num shl bitCount) or i.toLong()
                if (num > base) num %= base
                ar[i] = num
            }
        }
    }
}