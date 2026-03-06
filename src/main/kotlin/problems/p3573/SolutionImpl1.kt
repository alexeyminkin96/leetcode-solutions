package problems.p3573

/**
 * **LeetCode Performance:**
 * - Runtime: `34 ms` (Beats `66.67%` of Kotlin submissions)
 * - Memory: `50.12 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * k)`
 * - Space: `O(k)`
 */
class SolutionImpl1 : Solution {
    private val none = Long.MIN_VALUE
    override fun maximumProfit(prices: IntArray, k: Int): Long {
        val w = k + 1
        var notT = LongArray(w) { none }
        var upT = LongArray(w) { none }
        var downT = LongArray(w) { none }
        notT[0] = 0

        for (i in 0 until prices.size) {
            val price = prices[i]

            val notTLocal = LongArray(w) { none }
            val upTLocal = LongArray(w) { none }
            val downTLocal = LongArray(w) { none }

            for (td in 0 until w) {
                if (notT[td] > notTLocal[td]) notTLocal[td] = notT[td]
                if (upT[td] > upTLocal[td]) upTLocal[td] = upT[td]
                if (downT[td] > downTLocal[td]) downTLocal[td] = downT[td]

                if (notT[td] != none) {
                    if (notT[td] - price > upTLocal[td]) upTLocal[td] = notT[td] - price
                    if (notT[td] + price > downTLocal[td]) downTLocal[td] = notT[td] + price
                }

                val tmr = td + 1
                if (tmr < w) {
                    if (upT[td] != none && upT[td] + price > notTLocal[tmr])
                        notTLocal[tmr] = upT[td] + price
                    if (downT[td] != none && downT[td] - price > notTLocal[tmr])
                        notTLocal[tmr] = downT[td] - price
                }
            }

            notT = notTLocal
            upT = upTLocal
            downT = downTLocal
        }
        var result = 0L
        for (i in 0 until w) {
            if (notT[i] > result) result = notT[i]
        }
        return result
    }
}