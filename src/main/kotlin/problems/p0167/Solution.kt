package problems.p0167

/**
 * **[Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)**
 *
 * **Description:**
 * - Find two numbers in a sorted array that sum to target.
 *
 * **Constraints:**
 * - Array sorted ascending.
 * - Exactly one valid pair exists.
 *
 * **Notes:**
 * - Indices are 1-based.
 *
 * **Examples:**
 * - Input: numbers = [2,7,11,15], target = 9
 * - Output: [1,2]
 * - Explanation: 2 + 7 = 9
 */
interface Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray
}