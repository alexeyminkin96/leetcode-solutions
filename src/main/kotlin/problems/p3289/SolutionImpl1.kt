package problems.p3289

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `88.89%` of Kotlin submissions)
 * - Memory: `45.18 MB` (Beats `88.89%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Iterate through array.
 * - Use HashSet to track seen numbers.
 * - On duplicate detection, add to result.
 *
 * **Techniques:**
 * - HashSet
 * - Single pass
 */
class SolutionImpl1 : Solution {
    override fun getSneakyNumbers(nums: IntArray): IntArray {
        val exists = HashSet<Int>()
        val result = IntArray(2)
        var resultIndex = 0

        for (i in 0 until nums.size) {
            if (exists.contains(nums[i])) {
                result[resultIndex++] = nums[i]
                if (resultIndex == 2) return result
            } else
                exists.add(nums[i])
        }
        return result
    }
}