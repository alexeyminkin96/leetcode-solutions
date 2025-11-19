package problems.p2154

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `87.50%`)
 * - Memory: `44.91 MB` (Beats `100.00%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Put all numbers in set
 * - Double original until not found
 *
 * **Techniques:**
 * - HashSet
 */
class SolutionImpl2 : Solution {
    override fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = HashSet<Int>()

        for (i in 0 until nums.size)
            set.add(nums[i])

        var varOrig = original
        while (set.contains(varOrig))
            varOrig *= 2

        return varOrig
    }
}