package problems.p3947

class SolutionImpl1 : Solution {
    override fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size
        val factorCounts = IntArray(100_001)
        for (item in items) factorCounts[item[0]]++
        val factorToBonus = IntArray(100_001) { -1 }
        for (item in items) {
            val factor = item[0]
            if (factorToBonus[factor] != -1) continue
            for (j in factor..100_000 step factor)
                factorToBonus[factor] += factorCounts[j]
        }
        var min = Int.MAX_VALUE
        for (item in items) min = Math.min(min, item[1])
        val dp = IntArray(budget + 1) { it / min }
        for (i in 0 until n) {
            if (factorToBonus[items[i][0]] == 0) continue
            val weight = 2
            val price = items[i][1]
            for (j in budget downTo price)
                dp[j] = Math.max(dp[j], dp[j - price] + weight)
        }
        return dp[budget]
    }
}