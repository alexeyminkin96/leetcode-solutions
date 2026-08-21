package problems.p3116

class SolutionImpl1 : Solution {
    override fun findKthSmallest(coins: IntArray, k: Int): Long {
        var min = 25
        for (c in coins) min = Math.min(c, min)
        var l = min.toLong()
        var r = k * min.toLong()
        while (l < r) {
            val mid = (l + r) shr 1
            var sum = 0L
            for (mask in 1 until (1 shl coins.size)) {
                var curLcm = 1L
                var sign = -1
                for (i in 0 until coins.size)
                    if ((mask shr i) and 1 == 1) {
                        curLcm = lcm(curLcm, coins[i])
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
