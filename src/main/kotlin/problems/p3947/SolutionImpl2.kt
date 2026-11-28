package problems.p3947

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `44 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `294.75 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/solutions/8627802/kotlin-onlogn-44ms-on-primitives-only-by-lib6)
 */
class SolutionImpl2 : Solution {
    override fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size
        val factorCounts = IntArray(n + 1)
        for (item in items) factorCounts[item[0]]++
        val factorToBonus = IntArray(n + 1) { -1 }
        for (item in items) {
            val factor = item[0]
            if (factorToBonus[factor] != -1) continue
            for (j in factor..n step factor)
                factorToBonus[factor] += factorCounts[j]
        }
        val priceAndBonuses = LongArray(n) { (items[it][1].toLong() shl 32) or factorToBonus[items[it][0]].toLong() }
        Arrays.sort(priceAndBonuses)
        val min = (priceAndBonuses[0] shr 32).toInt()
        var res = 0
        var budget = budget
        for (priceAndBonus in priceAndBonuses) {
            val price = (priceAndBonus shr 32).toInt()
            if (price >= min shl 1 || price > budget) break
            val bonusCount = Math.min(priceAndBonus.toInt(), budget / price)
            res += 2 * bonusCount
            budget -= price * bonusCount
        }
        res += budget / min
        return res
    }
}