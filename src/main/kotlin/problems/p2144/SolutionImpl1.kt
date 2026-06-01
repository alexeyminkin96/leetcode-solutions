package problems.p2144

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun minimumCost(cost: IntArray): Int {
        Arrays.sort(cost)
        var res = 0
        for (i in cost.size - 1 downTo 0)
            if ((cost.size - i) % 3 != 0) res += cost[i]
        return res
    }
}