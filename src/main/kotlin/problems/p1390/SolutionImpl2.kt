package problems.p1390

/**
 * **LeetCode Performance:**
 * - Runtime: `935 ms` (Beats `15.38%` of Kotlin submissions)
 * - Memory: `48.48 MB` (Beats `53.85%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun sumFourDivisors(nums: IntArray): Int {
        var result = 0
        outer@ for (i in 0 until nums.size) {
            var num = nums[i]
            var divider = 2
            var count = 0
            val ar = IntArray(3)
            while (divider <= num) {
                val division = num / divider
                if (divider * division == num) {
                    if (++count > 3) continue@outer
                    num = division
                    ar[count - 1] = divider
                } else divider++
            }
            if (ar[0] != 0 && ar[0] == ar[1] && ar[1] == ar[2]) {
                result += ar[0] + ar[1] * ar[2] + 1 + nums[i]
            } else if (ar[0] != ar[1] && ar[1] != 0 && ar[2] == 0)
                result += ar[0] + ar[1] + 1 + nums[i]
        }
        return result
    }
}