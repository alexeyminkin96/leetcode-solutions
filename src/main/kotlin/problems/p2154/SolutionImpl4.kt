package problems.p2154

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%`)
 * - Memory: `47.44 MB` (Beats `25.00%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)` // fixed array
 *
 * **Approach:**
 * - Check numbers equal to original * 2^k
 * - Save powers in small array
 * - Find first missing power
 *
 * **Techniques:**
 * - Math check
 * - Small fixed array
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/keep-multiplying-found-values-by-two/solutions/7359901/kotlin-on-1ms-o1-not-hastable-single-pas-i84d)
 */
class SolutionImpl4 : Solution {
    override fun findFinalValue(nums: IntArray, original: Int): Int {
        val array = IntArray(11)

        for (i in 0 until nums.size) {
            val div = nums[i] / original
            if (Integer.bitCount(div) == 1 && nums[i] == div * original)
                array[Integer.numberOfTrailingZeros(div)] = nums[i]
        }

        var i = -1
        while (array[i + 1] != 0)
            i++

        return if (i == -1) original else array[i] * 2
    }
}