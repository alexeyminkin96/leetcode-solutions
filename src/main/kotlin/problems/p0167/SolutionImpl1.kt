package problems.p0167

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `95.87%` of Kotlin submissions)
 * - Memory: `50.60 MB` (Beats `62.26%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use two pointers from both ends
 * - Move left/right depending on sum
 * - Stop when sum equals target
 *
 * **Techniques:**
 * - Two pointers
 * - Sorted array traversal
 */
class SolutionImpl1 : Solution {
    override fun twoSum(numbers: IntArray, target: Int): IntArray {
        var leftIndex = 0
        var rightIndex = numbers.size - 1
        var sum: Int

        while (leftIndex < rightIndex) {
            sum = numbers[leftIndex] + numbers[rightIndex]
            if (sum == target) return intArrayOf(leftIndex + 1, rightIndex + 1)
            if (sum < target) leftIndex++ else rightIndex--
        }

        throw RuntimeException("Sum not found")
    }
}