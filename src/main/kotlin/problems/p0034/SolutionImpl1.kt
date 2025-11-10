package problems.p0034

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.38 MB` (Beats `70.43%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)` — two binary searches.
 * - Space: `O(1)` — only constant extra space.
 *
 * **Approach:**
 * - Step 1: Binary search for the first occurrence of the target.
 * - Step 2: Binary search for the last occurrence of the target.
 * - Step 3: Return both indices or `[-1, -1]` if not found.
 *
 * **Techniques:**
 * - Binary Search
 * - Two-pass search (leftmost and rightmost bounds)
 */
class SolutionImpl1 : Solution {
    override fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2) { -1 }

        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val i = start + (end - start) / 2
            when {
                target < nums[i] -> end = i - 1
                target > nums[i] -> start = i + 1
                target == nums[i] -> if (i == 0 || nums[i - 1] < nums[i]) {
                    result[0] = i
                    break
                } else end = i - 1
            }
        }

        start = 0
        end = nums.size - 1

        while (start <= end) {
            val i = start + (end - start) / 2
            when {
                target < nums[i] -> end = i - 1
                target > nums[i] -> start = i + 1
                target == nums[i] -> if (i == nums.size - 1 || nums[i] < nums[i + 1]) {
                    result[1] = i
                    break
                } else start = i + 1
            }
        }

        return result
    }
}