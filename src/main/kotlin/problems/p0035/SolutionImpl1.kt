package problems.p0035

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.26 MB` (Beats `64.51%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)` — binary search
 * - Space: `O(1)` — only few variables used
 *
 * **Approach:**
 * - Use binary search on sorted array.
 * - Move `start` or `end` based on value compare.
 * - If not found, `start` is correct insert position.
 */
class SolutionImpl1 : Solution {
    override fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val i = start + (end - start) / 2
            when {
                target < nums[i] -> end = i - 1
                target > nums[i] -> start = i + 1
                target == nums[i] -> return i
            }
        }

        return start
    }
}