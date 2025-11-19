package problems.p2154

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%`)
 * - Memory: `46.02 MB` (Beats `87.50%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Scan nums
 * - Double on match
 * - Use set to skip already-seen values
 *
 * **Techniques:**
 * - HashSet
 * - Single pass
 */
class SolutionImpl3 : Solution {
    override fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = HashSet<Int>()

        var varOrig = original
        for (i in 0 until nums.size) {
            if (nums[i] == varOrig) {
                varOrig *= 2
                while (set.contains(varOrig))
                    varOrig *= 2
            } else if (nums[i] > varOrig)
                set.add(nums[i])
        }
        return varOrig
    }
}