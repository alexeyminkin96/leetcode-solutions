package problems.p3013

import java.util.TreeSet

/**
 * **LeetCode Performance:**
 * - Runtime: `177 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `80.12 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log(dist))`
 * - Space: `O(dist)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/solutions/7545203/kotlin-onlogd-177ms-od-not-pq-only-one-t-duvf)
 */
class SolutionImpl2 : Solution {
    private val base = 1_000_000L
    override fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        val dist = dist + 1
        val k = k - 1
        val sort = TreeSet<Long>()
        for (i in 1..dist) {
            sort.add(nums[i] * base + i)
        }
        val it = sort.iterator()
        var currentSum = 0L
        for (i in 0 until k - 1) {
            currentSum += it.next() / base
        }
        var max = it.next()
        currentSum += max / base
        var minSum = currentSum

        for (i in dist + 1 until nums.size) {
            val added = nums[i] * base + i
            sort.add(added)
            val deleted = nums[i - dist] * base + (i - dist)
            sort.remove(deleted)

            if (added > max && deleted > max) continue
            if (added < max && deleted < max) {
                currentSum += nums[i]
                currentSum -= nums[i - dist]
                minSum = Math.min(minSum, currentSum)
                continue
            }
            if (added < max) {
                currentSum += nums[i]
                currentSum -= max / base
                max = sort.lower(max)!!
            }
            if (deleted <= max) {
                currentSum -= nums[i - dist]
                max = sort.higher(max)!!
                currentSum += max / base
            }
            minSum = Math.min(minSum, currentSum)
        }

        return nums[0] + minSum
    }
}