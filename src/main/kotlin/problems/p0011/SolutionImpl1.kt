package problems.p0011

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `98.55%` of Kotlin submissions)
 * - Memory: `59.93 MB` (Beats `70.70%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use two pointers at both ends of the array.
 * - Move the pointer with the smaller height inward.
 * - Track the maximum area found.
 *
 * **Techniques:**
 * - Two Pointers
 */
class SolutionImpl1 : Solution {
    override fun maxArea(height: IntArray): Int {
        var maxValue = 0

        var leftIndex = 0
        var rightIndex = height.size - 1

        while (leftIndex < rightIndex) {
            val leftHeight = height[leftIndex]
            val rightHeight = height[rightIndex]

            val value = if (leftHeight > rightHeight)
                rightHeight * (rightIndex-- - leftIndex)
            else
                leftHeight * (rightIndex - leftIndex++)

            if (value > maxValue) maxValue = value
        }

        return maxValue
    }
}