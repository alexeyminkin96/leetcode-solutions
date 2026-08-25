package problems.p3718

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.66 MB` (Beats `99.72%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-missing-multiple-of-k/solutions/8499571/kotlin-on-1ms-o1-by-alexeyminkin-bbaz)
 */
class SolutionImpl1 : Solution {
    override fun missingMultiple(nums: IntArray, k: Int): Int {
        val persist = BooleanArray(100 / k + 1)
        for (num in nums)
            if (num % k == 0) persist[num / k - 1] = true
        var i = 0
        while (persist[i]) i++
        return (i + 1) * k
    }
}