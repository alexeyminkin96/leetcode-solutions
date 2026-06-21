package problems.p1833

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `60.75 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + C)`, `C = 100000`
 * - Space: `O(C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-ice-cream-bars/solutions/8350040/kotlin-onc-5ms-oc-by-alexeyminkin-436l)
 */
class SolutionImpl2 : Solution {
    override fun maxIceCream(costs: IntArray, coins: Int): Int {
        val sort = IntArray(100_001)
        for (i in 0 until costs.size)
            sort[costs[i]]++
        var count = 0
        var rem = coins
        for (i in 0 until sort.size) {
            val all = sort[i] * i
            if (all <= rem) {
                rem -= all
                count += sort[i]
            } else {
                count += rem / i
                break
            }
        }
        return count
    }
}