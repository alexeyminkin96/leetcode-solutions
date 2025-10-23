package problems.p0027

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.15 MB` (Beats `85.95%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use two pointers.
 * - Move non-matching elements to front.
 *
 * **Techniques:**
 * - Two Pointers
 * - In-place mutation
 */
class SolutionImpl1 : Solution {
    override fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0

        for (i in 0 until nums.size)
            if (nums[i] != `val`)
                nums[left++] = nums[i]

        return left
    }
}