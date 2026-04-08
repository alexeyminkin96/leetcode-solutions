package problems.p3653

/**
 * **LeetCode Performance:**
 * - Runtime: `47 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `70.04 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(q * n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/xor-after-range-multiplication-queries-i/solutions/7824229/kotlin-onq-47ms-o1-by-alexeyminkin-ef66)
 */
class SolutionImpl1 : Solution {
    override fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007
        for (i in 0 until queries.size) {
            val v = queries[i][3]
            for (j in queries[i][0]..queries[i][1] step queries[i][2])
                nums[j] = ((nums[j].toLong() * v) % mod).toInt()
        }
        var res = nums[0]
        for (i in 1 until nums.size)
            res = res xor nums[i]
        return res
    }
}
