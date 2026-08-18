package problems.p3471

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.06 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-largest-almost-missing-integer/solutions/8467679/kotlin-on-1ms-o1-by-alexeyminkin-1gk3https://leetcode.com/problems/find-the-largest-almost-missing-integer/solutions/8467679/kotlin-on-1ms-o1-by-alexeyminkin-1gk3)
 */
class SolutionImpl1 : Solution {
    override fun largestInteger(nums: IntArray, k: Int): Int {
        val n = nums.size
        val c = IntArray(51)
        for (num in nums) c[num]++
        when (k) {
            1 -> for (i in c.size - 1 downTo 0) if (c[i] == 1) return i
            n -> for (i in c.size - 1 downTo 0) if (c[i] != 0) return i
            else -> return Math.max(if (c[nums[0]] == 1) nums[0] else -1, if (c[nums[n - 1]] == 1) nums[n - 1] else -1)
        }
        return -1
    }
}