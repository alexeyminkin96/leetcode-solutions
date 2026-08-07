package problems.p3348

/**
 * **LeetCode Performance:**
 * - Runtime: `18 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.82 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + log(n))`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-divisible-digit-product-ii/solutions/8447146/kotlin-onlogt-18ms-o1-primitives-only-by-00au)
 */
class SolutionImpl1 : Solution {
    override fun smallestNumber(num: String, t: Long): String {
        var t = t
        val num = num.toCharArray()
        val n = num.size

        fun countPrime(prime: Int): Int {
            var count = 0
            while (t % prime == 0L) {
                t /= prime
                count++
            }
            return count
        }

        val t2 = countPrime(2)
        val t3 = countPrime(3)
        val t5 = countPrime(5)
        val t7 = countPrime(7)

        if (t != 1L) return "-1"

        var n2 = 0
        var n3 = 0
        var n5 = 0
        var n7 = 0

        fun moveDig(dig: Char, coef: Int) {
            when (dig) {
                '2' -> n2 += coef
                '3' -> n3 += coef
                '4' -> n2 += 2 * coef
                '5' -> n5 += coef
                '6' -> {
                    n2 += coef
                    n3 += coef
                }

                '7' -> n7 += coef
                '8' -> n2 += 3 * coef
                '9' -> n3 += 2 * coef
            }
        }

        var hasZero = false
        for (i in 0 until n) {
            if (num[i] == '0') hasZero = true
            if (hasZero) num[i] = '1'
            else moveDig(num[i], 1)
        }

        if (n2 >= t2 && n3 >= t3 && n5 >= t5 && n7 >= t7) return String(num)
        val minDigs = minDigs(t2, t3, t5, t7)
        if (minDigs > n) return String(createMinRes(CharArray(minDigs), 0, t2, t3, t5, t7))

        for (i in n - 1 downTo 0) {
            val last = num[i]
            moveDig(last, -1)
            for (d in last + 1..'9') {
                moveDig(d, 1)
                val need2 = Math.max(0, t2 - n2)
                val need3 = Math.max(0, t3 - n3)
                val need5 = Math.max(0, t5 - n5)
                val need7 = Math.max(0, t7 - n7)
                if (minDigs(need2, need3, need5, need7) <= n - 1 - i) {
                    num[i] = d
                    return String(createMinRes(num, i + 1, need2, need3, need5, need7))
                }
                moveDig(d, -1)
            }
        }

        return String(createMinRes(CharArray(n + 1), 0, t2, t3, t5, t7))
    }

    private fun minDigs(p2: Int, p3: Int, p5: Int, p7: Int): Int {
        var res = p3 / 2 + p2 / 3 + p7
        var r2 = p2 % 3
        var r3 = p3 % 2
        if (r2 != 0 && r3 != 0) {
            res++
            r2--
            r3--
        }
        res += p5 + (r2 + 1) / 2 + r3
        return res
    }

    private fun createMinRes(res: CharArray, from: Int, p2: Int, p3: Int, p5: Int, p7: Int): CharArray {
        var i = res.size - 1
        for (k in 0 until p3 / 2) res[i--] = '9'
        var r3 = p3 % 2
        for (k in 0 until p2 / 3) res[i--] = '8'
        var r2 = p2 % 3
        for (k in 0 until p7) res[i--] = '7'
        if (r2 != 0 && r3 != 0) {
            res[i--] = '6'
            r2--
            r3--
        }
        for (k in 0 until p5) res[i--] = '5'
        for (k in 0 until r2 / 2) res[i--] = '4'
        r2 %= 2
        for (k in 0 until r3) res[i--] = '3'
        for (k in 0 until r2) res[i--] = '2'
        while (i >= from) res[i--] = '1'
        return res
    }
}