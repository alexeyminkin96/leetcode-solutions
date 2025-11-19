package problems.p2154

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%`)
 * - Memory: `46.79 MB` (Beats `37.50%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Detect values == original * 2^k
 * - Mark powers using bitmask
 * - Find first missing bit
 *
 * **Techniques:**
 * - Bitmask
 * - Math check
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/keep-multiplying-found-values-by-two/solutions/7359901/kotlin-on-1ms-o1-not-hastable-single-pas-i84d)
 */
class SolutionImpl5 : Solution {
    override fun findFinalValue(nums: IntArray, original: Int): Int {
        var bits = 0

        for (i in 0 until nums.size) {
            val div = nums[i] / original
            if (Integer.bitCount(div) == 1 && nums[i] == div * original)
                bits = bits or div
        }

        var powerOfTwo = 1

        while (bits and powerOfTwo != 0)
            powerOfTwo = powerOfTwo shl 1

        return original * powerOfTwo
    }
}