package problems.p3895

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `80.77%` of Kotlin submissions)
 * - Memory: `49.07 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*C)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-digit-appearances/solutions/7874001/kotlin-on-4ms-o1-by-alexeyminkin-kcb8)
 */
class SolutionImpl1 : Solution {
    override fun countDigitOccurrences(nums: IntArray, digit: Int): Int {
        var res = 0
        for (i in 0 until nums.size) {
            var num = nums[i]
            while (num != 0) {
                val div = num / 10
                if (num - div * 10 == digit) res++
                num = div
            }
        }
        return res
    }
}