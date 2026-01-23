package problems.p3507

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `83.33%` of Kotlin submissions)
 * - Memory: `43.47 MB` (Beats `83.33%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {
    private val base = 100
    override fun minimumPairRemoval(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        val prev = IntArray(n)
        val next = IntArray(n)
        val values = LongArray(n)
        val h = PriorityQueue<Long>(n)
        var bads = 0

        for (i in 0 until n) {
            if (i + 1 < n) {
                if (nums[i] > nums[i + 1]) bads++
                h.add((nums[i].toLong() + nums[i + 1]) * base + i)
            }
            values[i] = nums[i].toLong()
            next[i] = i + 1
            prev[i] = i - 1
        }

        while (bads > 0) {
            var sum: Long
            var i: Int
            var nextI: Int
            do {
                val s = h.poll()
                sum = Math.floorDiv(s, base)
                i = Math.floorMod(s, base)
                nextI = next[i]
            } while (nextI == n || values[i] + values[nextI] != sum)
            val prevI = prev[i]
            val afterNextI = next[nextI]

            if (values[i] > values[nextI]) bads--

            if (prevI >= 0) {
                if (values[prevI] > values[i]) bads--
                if (values[prevI] > sum) bads++
                h.add((values[prevI] + sum) * base + prevI)
            }
            if (afterNextI < n) {
                if (values[nextI] > values[afterNextI]) bads--
                if (sum > values[afterNextI]) bads++
                prev[afterNextI] = i
                h.add((sum + values[afterNextI]) * base + i)
            }
            values[i] = sum
            next[i] = afterNextI
            next[nextI] = n
            result++
        }
        return result
    }
}