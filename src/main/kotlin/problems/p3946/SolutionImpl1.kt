package problems.p3946

class SolutionImpl1 : Solution {
    override fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size
        val bonuses = IntArray(n)
        for (i in 0 until n - 1) {
            val factorI = items[i][0]
            for (j in i + 1 until n) {
                val factorJ = items[j][0]
                if (factorI % factorJ == 0) bonuses[j]++
                if (factorJ % factorI == 0) bonuses[i]++
            }
        }
        var min = Int.MAX_VALUE
        for (item in items) min = Math.min(min, item[1])
        val dp = IntArray(budget + 1) { it / min }
        for (i in 0 until n) {
            if (bonuses[i] == 0) continue
            val weight = bonuses[i] + 1
            val price = items[i][1]
            for (j in budget downTo price)
                dp[j] = Math.max(dp[j], dp[j - price] + weight)
        }
        return dp[budget]
    }
}