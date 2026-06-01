package problems.p2144

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.23 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(C)` C=100
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/solutions/8306550/kotlin-on-1ms-oc-by-alexeyminkin-z2ir)
 */
class SolutionImpl2 : Solution {
    override fun minimumCost(cost: IntArray): Int {
        val sort = IntArray(101)
        for (i in 0 until cost.size) sort[cost[i]]++
        var res = 0
        var count = 0
        for (i in sort.size - 1 downTo 0) {
            res += (sort[i] - (sort[i] + count) / 3) * i
            count = (count + sort[i]) % 3
        }
        return res
    }
}