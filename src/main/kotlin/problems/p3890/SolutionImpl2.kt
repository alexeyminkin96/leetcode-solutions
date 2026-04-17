package problems.p3890

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `47 ms` (Beats `96.88%` of Kotlin submissions)
 * - Memory: `76.99 MB` (Beats `90.63%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(1)` average per query after precomputation, `O(C^2 + k log k)` preprocessing where `C = 1000`
 * - Space: `O(k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/solutions/7965896/kotlin-c2-klogk-47ms-ok-precalculate-by-orf2k)
 */
class SolutionImpl2 : Solution {
    override fun findGoodIntegers(n: Int): IntArray {
        var idx = Arrays.binarySearch(goods, n) + 1
        if (idx < 0) idx = -idx
        return Arrays.copyOf(goods, idx)
    }

    companion object {
        private val goods: IntArray

        init {
            val once = HashSet<Int>(500_000)
            val twice = HashSet<Int>(2_000)
            val n = 1_000_000_000
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
            goods = IntArray(twice.size)
            var i = 0
            for (num in twice)
                goods[i++] = num
            Arrays.sort(goods)
        }
    }
}
