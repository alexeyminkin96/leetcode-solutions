package problems.p3562

/**
 * **LeetCode Performance:**
 * - Runtime: `118 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `50.86 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * budget^2)`
 * - Space: `O(n * budget)`
 */
class SolutionImpl1 : Solution {
    private val none = Int.MIN_VALUE

    override fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
        val arSize = budget + 1
        val children = Array(n) { ArrayList<Int>() }
        for (i in 0 until hierarchy.size) {
            children[hierarchy[i][0] - 1].add(hierarchy[i][1] - 1)
        }

        fun merge(a: IntArray, b: IntArray): IntArray {
            val result = IntArray(arSize) { none }
            for (i in 0..budget) {
                if (a[i] == none) continue
                for (j in 0..budget - i) {
                    if (b[j] == none) continue
                    val sum = a[i] + b[j]
                    if (sum > result[i + j]) result[i + j] = sum
                }
            }
            return result
        }

        fun dfs(index: Int): Array<IntArray> {
            var kidsNoBuy = IntArray(arSize) { none }
            kidsNoBuy[0] = 0
            var kidsBuy = IntArray(arSize) { none }
            kidsBuy[0] = 0

            for (child in children[index]) {
                val childDps = dfs(child)
                kidsNoBuy = merge(kidsNoBuy, childDps[0])
                kidsBuy = merge(kidsBuy, childDps[1])
            }

            val costFull = present[index]
            val costDisc = costFull / 2

            val dp0 = kidsNoBuy.copyOf()
            val dp1 = kidsNoBuy.copyOf()

            for (b in 0 until arSize) {
                if (b >= costFull) {
                    val base = kidsBuy[b - costFull]
                    if (base != none) {
                        val sum = future[index] - costFull + base
                        if (sum > dp0[b]) dp0[b] = sum
                    }
                }
                if (b >= costDisc) {
                    val base = kidsBuy[b - costDisc]
                    if (base != none) {
                        val sum = future[index] - costDisc + base
                        if (sum > dp1[b]) dp1[b] = sum
                    }
                }
            }

            return arrayOf(dp0, dp1)
        }

        val dpRoot = dfs(0)[0]
        var result = 0
        for (b in 0 until arSize)
            if (dpRoot[b] > result) result = dpRoot[b]
        return result
    }
}