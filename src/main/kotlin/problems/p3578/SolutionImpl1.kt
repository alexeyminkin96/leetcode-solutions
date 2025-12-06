package problems.p3578

import java.util.LinkedList

/**
 * **LeetCode Performance:**
 * - Runtime: `65 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `64.74 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun countPartitions(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        val preDp = LongArray(nums.size + 1)
        preDp[0] = 1
        val mins = LinkedList<Int>()
        val maxs = LinkedList<Int>()

        var l = 0

        for (i in 0 until nums.size) {
            while (!mins.isEmpty() && (nums[mins.last] >= nums[i])) {
                mins.removeLast()
            }
            mins.add(i)

            while (!maxs.isEmpty() && (nums[i] >= nums[maxs.last])) {
                maxs.removeLast()
            }
            maxs.add(i)

            while (nums[maxs.first] - nums[mins.first] > k) {
                l = if (mins.first < maxs.first)
                    mins.removeFirst() + 1
                else
                    maxs.removeFirst() + 1
            }

            preDp[i + 1] = (2 * preDp[i] + mod - if (l == 0) 0 else preDp[l - 1]) % mod
        }
        return ((preDp[preDp.size - 1] - preDp[preDp.size - 2] + mod) % mod).toInt()
    }
}