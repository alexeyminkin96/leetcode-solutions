package problems.p2154

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `87.50%`)
 * - Memory: `46.81 MB` (Beats `37.50%`)
 *
 * **Complexity:**
 * - Time: `O(n log n)`  // sorting
 * - Space: `O(1)`       // in-place sort
 *
 * **Approach:**
 * - Sort array
 * - Move through values
 * - Double when match
 *
 * **Techniques:**
 * - Sorting
 * - Linear scan
 */
class SolutionImpl1 : Solution {
    override fun findFinalValue(nums: IntArray, original: Int): Int {
        Arrays.sort(nums)

        var varOrig = original
        for (i in 0 until nums.size)
            if (nums[i] == varOrig)
                varOrig *= 2
        return varOrig
    }
}