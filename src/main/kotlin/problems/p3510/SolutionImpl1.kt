package problems.p3510

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `387 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `108.96 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii/solutions/7517475/kotlin-onlogn-387ms-on-by-alexeyminkin-4aad)
 */
class SolutionImpl1 : Solution {
    override fun minimumPairRemoval(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        val prev = IntArray(n)
        val next = IntArray(n)
        val values = LongArray(n)
        val heap = PriorityQueue(n, comparator)
        var bads = 0

        for (i in 0 until n) {
            if (i + 1 < n) {
                if (nums[i] > nums[i + 1]) bads++
                heap.add(Pair(nums[i].toLong() + nums[i + 1], i))
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
                val s = heap.poll()
                sum = s.first
                i = s.second
                nextI = next[i]
            } while (nextI == n || values[i] + values[nextI] != sum)
            val prevI = prev[i]
            val afterNextI = next[nextI]

            if (values[i] > values[nextI]) bads--

            if (prevI >= 0) {
                if (values[prevI] > values[i]) bads--
                if (values[prevI] > sum) bads++
                heap.add(Pair(values[prevI] + sum, prevI))
            }
            if (afterNextI < n) {
                if (values[nextI] > values[afterNextI]) bads--
                if (sum > values[afterNextI]) bads++
                prev[afterNextI] = i
                heap.add(Pair(sum + values[afterNextI], i))
            }
            values[i] = sum
            next[i] = afterNextI
            next[nextI] = n
            result++
        }
        return result
    }

    companion object {
        private val comparator = compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second }
    }
}