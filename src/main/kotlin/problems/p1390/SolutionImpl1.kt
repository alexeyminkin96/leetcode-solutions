package problems.p1390

import kotlin.math.sqrt

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `84.62%` of Kotlin submissions)
 * - Memory: `48.56 MB` (Beats `46.15%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * sqrt(m))`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/four-divisors/solutions/7464455/kotlin-onsqrtm-9ms-om-caching-by-alexeym-tppd)
 */
class SolutionImpl1 : Solution {
    companion object {
        val sums = IntArray(100_001) { -1 }
    }

    override fun sumFourDivisors(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (sums[num] != -1) {
                result += sums[num]
                continue
            }
            sums[num] = 0
            var divider = 2
            var count = 0
            var sum = 1 + num
            val sqrtNum = sqrt(num.toDouble())
            while (divider <= sqrtNum) {
                val division = num / divider
                if (divider * division == num) {
                    sum += divider
                    if (divider != division) {
                        sum += division
                        count++
                    }
                    if (++count > 2) break
                }
                divider++
            }
            if (count == 2) {
                result += sum
                sums[num] = sum
            }
        }
        return result
    }
}