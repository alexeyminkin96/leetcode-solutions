package problems.p3488

/**
 * **LeetCode Performance:**
 * - Runtime: `55 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `93.58 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + q)`
 * - Space: `O(n + 10^6)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/closest-equal-element-queries/solutions/7935826/kotlin-onq-55ms-onq-primitives-by-alexey-55hv)
 */
class SolutionImpl1 : Solution {
    override fun solveQueries(nums: IntArray, queries: IntArray): IntArray {
        val n = nums.size
        val dists = IntArray(n) { Int.MAX_VALUE }
        val map = IntArray(1_000_001)
        for (i in 0 until n)
            map[nums[i]] = i

        for (i in 0 until n) {
            val num = nums[i]
            val prevIdx = map[num]
            map[num] = i
            if (prevIdx != i) {
                val dist = (i - prevIdx + n) % n
                dists[i] = Math.min(dists[i], dist)
                dists[prevIdx] = Math.min(dists[prevIdx], dist)
            } else dists[i] = -1
        }

        for (i in 0 until queries.size)
            queries[i] = dists[queries[i]]
        return queries
    }
}