package problems.p3013

import java.util.TreeSet

/**
 * **LeetCode Performance:**
 * - Runtime: `186 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `70.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log(dist))`
 * - Space: `O(dist)`
 */
class SolutionImpl1 : Solution {
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
            if (added < max) {
                currentSum += nums[i]
                currentSum -= max / base
                max = sort.lower(max)!!
            }

            val deleted = nums[i - dist] * base + (i - dist)
            sort.remove(deleted)
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