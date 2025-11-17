package problems.p1437

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.36 MB` (Beats `66.67%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Keep distance counter
 * - When see 1: check distance >= k
 * - Reset distance after 1
 *
 * **Techniques:**
 * - Simple loop
 * - Counter logic
 */
class SolutionImpl1 : Solution {
    override fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var distance = k
        for (i in 0 until nums.size) {
            if (nums[i] == 1) {
                if (distance < k) return false
                distance = 0
            } else
                distance++
        }
        return true
    }
}