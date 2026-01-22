package problems.p3507

import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `10 ms` (Beats `85.71%` of Kotlin submissions)
 * - Memory: `45.92 MB` (Beats `85.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/solutions/7514994/kotlin-onlogn-10ms-on-by-alexeyminkin-eqky)
 */
class SolutionImpl2 : Solution {
    override fun minimumPairRemoval(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        val prev = IntArray(n)
        val next = IntArray(n)
        val dropped = BooleanArray(n)
        val values = IntArray(n)
        val heap = PriorityQueue(n, compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second })
        var bads = 0

        for (i in 0 until n) {
            if (i + 1 < n) {
                if (nums[i] > nums[i + 1]) bads++
                heap.add(Triple(nums[i] + nums[i + 1], i, i + 1))
            }
            values[i] = nums[i]
            next[i] = i + 1
            prev[i] = i - 1
        }

        while (bads > 0) {
            var minSum: Triple<Int, Int, Int>
            do minSum = heap.poll()
            while (dropped[minSum.second] || values[minSum.second] + values[minSum.third] != minSum.first || dropped[minSum.third] || next[minSum.second] != minSum.third)
            val i = minSum.second
            if (prev[i] >= 0 && values[prev[i]] > values[i]) bads--
            if (next[i] < n) {
                if (values[i] > values[next[i]]) bads--
                if (next[next[i]] < n && values[next[i]] > values[next[next[i]]]) bads--
            }
            values[i] = minSum.first
            if (prev[i] >= 0) {
                if (values[prev[i]] > values[i]) bads++
                heap.add(Triple(values[prev[i]] + values[i], prev[i], i))
            }
            if (next[i] < n) {
                dropped[next[i]] = true
                if (next[next[i]] < n) {
                    prev[next[next[i]]] = i
                    if (values[i] > values[next[next[i]]]) bads++
                    heap.add(Triple(values[i] + values[next[next[i]]], i, next[next[i]]))
                }
                next[i] = next[next[i]]
            }
            result++

        }
        return result
    }
}