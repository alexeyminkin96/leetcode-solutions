package problems.p0027

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.50 MB` (Beats `49.64%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use fold accumulator.
 * - Increment index and overwrite in-place.
 *
 * **Techniques:**
 * - Functional fold
 *
 * **Notes:**
 * - Kotlin one-line style.
 */
class SolutionImpl2 : Solution {
    override fun removeElement(nums: IntArray, `val`: Int): Int {
        return nums.fold(0) { f, num -> if (num == `val`) f else (f + 1).also { nums[f] = num } }
    }
}