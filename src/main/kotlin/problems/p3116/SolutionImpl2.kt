package problems.p3116

class SolutionImpl2 : Solution {
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
        while (l < r) {
            val mid = (l + r) shr 1
            var sum = 0L
            for (mask in 1 until (1 shl n)) {
                var curLcm = 1L
                var sign = -1
                for (i in 0 until n)
                    if ((mask shr i) and 1 == 1) {
                        curLcm = lcm(curLcm, newCoins[i])
                        sign *= -1
                    }
                sum += mid / curLcm * sign
            }
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
