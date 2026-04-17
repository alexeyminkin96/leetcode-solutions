package problems.p3890

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun findGoodIntegers(n: Int): IntArray {
        val once = HashSet<Int>()
        val twice = HashSet<Int>()
        var a = 1
        var aCube = 1
        while (aCube shl 1 <= n) {
            var b = a
            var sum = aCube + b * b * b
            while (sum <= n) {
                if (!once.add(sum)) twice.add(sum)
                sum = aCube + ++b * b * b
            }
            aCube = ++a * a * a
        }
        val goods = IntArray(twice.size)
        var i = 0
        for (num in twice)
            goods[i++] = num
        Arrays.sort(goods)
        return goods
    }
}
