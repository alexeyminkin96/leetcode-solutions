package problems.p1833

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun maxIceCream(costs: IntArray, coins: Int): Int {
        Arrays.sort(costs)
        var count = 0
        var rem = coins
        for (i in 0 until costs.size) {
            val cost = costs[i]
            if (rem < cost) break
            rem -= cost
            count++
        }
        return count
    }
}