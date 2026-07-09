package problems.p3532

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `115.51 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + q)`, where `q = queries.size`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/path-existence-queries-in-a-graph-i/solutions/8385915/kotlin-onq-3ms-on-by-alexeyminkin-5785)
 */
class SolutionImpl2 : Solution {
    override fun pathExistenceQueries(n: Int, nums: IntArray, maxDiff: Int, queries: Array<IntArray>): BooleanArray {
        var start = 0
        var prev = nums[0]
        val connection = IntArray(n)
        for (i in 1 until n) {
            val cur = nums[i]
            if (cur - prev > maxDiff) start = i
            connection[i] = start
            prev = cur
        }
        val res = BooleanArray(queries.size)
        for (i in 0 until queries.size) {
            val query = queries[i]
            res[i] = connection[query[0]] == connection[query[1]]
        }
        return res
    }
}