package problems.p3289

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.76 MB` (Beats `76.92%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Traverse array once.
 * - Use in-place marking: flip value sign to track visits.
 * - If value already negative, it's a duplicate.
 * - Store duplicates in result.
 *
 * **Techniques:**
 * - In-place modification
 * - Sign marking
 *
 * **Notes:**
 * - Mutates input array.
 * - Subtract 1 when negating to handle value 0 correctly.
 * - [Full explanation](https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/solutions/7318128/kotlin-on-o1-not-hastable-single-pass-on-421b)
 */
class SolutionImpl2 : Solution {
    override fun getSneakyNumbers(nums: IntArray): IntArray {
        val result = IntArray(2)
        var resultIndex = 0

        for (i in 0 until nums.size) {
            val num = if (nums[i] < 0) -nums[i] - 1 else nums[i]
            if (nums[num] < 0) {
                result[resultIndex++] = num
                if (resultIndex == 2) return result
            } else
                nums[num] = -nums[num] - 1
        }
        return result
    }
}