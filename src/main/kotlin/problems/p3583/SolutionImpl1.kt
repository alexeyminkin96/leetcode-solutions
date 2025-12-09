package problems.p3583

/**
 * **LeetCode Performance:**
 * - Runtime: `129 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `81.27 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * - [Full explanation](https://leetcode.com/problems/count-special-triplets/solutions/7402107/kotlin-on-129ms-on-2-pass-by-alexeyminki-rmdb)
 */
class SolutionImpl1 : Solution {
    override fun specialTriplets(nums: IntArray): Int {
        val valueToCount = HashMap<Int, Long>()
        val counts = LongArray(nums.size)
        val values = IntArray(nums.size)
        for (i in 0 until nums.size) {
            counts[i] = valueToCount[nums[i] * 2] ?: 0
            values[i] = nums[i] * 2
            valueToCount[nums[i]] = (valueToCount[nums[i]] ?: 0) + 1
        }
        var result = 0L

        for (i in 0 until counts.size) {
            val count = counts[i]
            if (count == 0L) continue
            val value = values[i]
            val allCount = valueToCount[value]!! - if (value == 0) 1 else 0
            result += count * (allCount - count)
        }
        return (result % 1_000_000_007).toInt()
    }
}