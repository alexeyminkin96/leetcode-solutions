package problems.p3644

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `185.78 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-k-to-sort-a-permutation/solutions/8584933/kotlin-on-2ms-o1-by-alexeyminkin-ybo5)
 */
class SolutionImpl1 : Solution {
    override fun sortPermutation(nums: IntArray): Int {
        var and = Int.MAX_VALUE
        for (i in 0 until nums.size)
            if (nums[i] != i) {
                and = and and i
                if (and == 0) return 0
            }
        return if (and == Int.MAX_VALUE) 0 else and
    }
}