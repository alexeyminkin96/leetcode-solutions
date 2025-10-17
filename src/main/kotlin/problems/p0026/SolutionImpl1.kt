package problems.p0026

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%`)
 * - Memory: `47.21 MB` (Beats `80.90%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Two pointers: slow keeps last unique, fast scans array.
 * - Copy new unique elements forward.
 *
 * **Techniques:**
 * - Two Pointers
 *
 * **Notes:**
 * - In-place deduplication, preserves order.
 */
class SolutionImpl1 : Solution {
    override fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for (i in 0 until nums.size)
            if (nums[index] != nums[i])
                nums[++index] = nums[i]

        return index + 1
    }
}