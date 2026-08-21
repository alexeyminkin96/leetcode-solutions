package problems.p3116

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.48 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(2^n * log(k * minCoin))`
 * - Space: `O(2^n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/solutions/8473969/kotlin-o2nlogkmincoins-3ms-o2n-primitive-5ely)
 */
class SolutionImpl3 : Solution {
    override fun findKthSmallest(coins: IntArray, k: Int): Long {
        val maxValue = 25
        var n = coins.size
        val counts = IntArray(maxValue + 1)
        var l = maxValue.toLong()
        for (coin in coins) {
            for (i in coin..maxValue step coin) counts[i]++
            if (coin < l) l = coin.toLong()
        }
        var r = k * l
        for (coin in coins) if (counts[coin] > 1) n--
        val newCoins = IntArray(n)
        var coinsI = 0
        for (coin in coins) if (counts[coin] == 1) newCoins[coinsI++] = coin
        val lcms = LongArray(1 shl n)
        lcms[0] = 1
        for (mask in 1 until (1 shl n))
            lcms[mask] = lcm(
                Math.abs(lcms[mask and (mask - 1)]), newCoins[Integer.numberOfTrailingZeros(mask)]
            ) * if (Integer.bitCount(mask) and 1 == 1) 1 else -1
        while (l < r) {
            val mid = (l + r) shr 1
            var sum = 0L
            for (mask in 1 until (1 shl n)) sum += mid / lcms[mask]
            if (sum < k) l = mid + 1 else r = mid
        }
        return l
    }

    private fun lcm(a: Long, b: Int): Long {
        return a * b / gcd(a, b.toLong())
    }

    private fun gcd(a: Long, b: Long): Long {
        var a = a
        var b = b
        while (b != 0L) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}
